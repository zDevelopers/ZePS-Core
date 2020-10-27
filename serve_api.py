# Python 3.5+ required

import os
import sys
import subprocess

from flask import Flask, request, make_response, jsonify
from path import Path


app = Flask(__name__)

if 'ZEPS_CORE_JAR' not in os.environ:
    print('Please specify ZePS-Core JAR with the ZEPS_CORE_JAR environment variable.', file=sys.stderr)
    sys.exit(1)

zeps_core = Path(os.environ.get('ZEPS_CORE_JAR')).expand()

if not zeps_core.exists():
    print('ZePS Core JAR not found. Check the ZEPS_CORE_JAR environment variable.', file=sys.stderr)
    sys.exit(1)


def call_core(command, *args):
    process = subprocess.run(['java', '-jar', zeps_core, command, *[str(arg) for arg in args]], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    try:
        process.check_returncode()
        return make_response(process.stdout, 200, {'Content-Type': 'application/json'})
    except Exception:
        return jsonify(error=str(process.stderr), exit_code=process.returncode)


@app.route('/list')
def list():
    return call_core('list')


@app.route('/list/network')
def list_with_network():
    return call_core('list', 'true')


@app.route('/path/<int:from_id>/<int:to_id>')
def path(from_id, to_id):
    official = 'official' in request.args
    accessible = 'accessible' in request.args
    return call_core('pathfinder', from_id, to_id, official, accessible)


@app.route('/colors')
def colors():
    return call_core('colors')


@app.route('/version')
def version():
    return jsonify(
        version=zeps_core.stem.replace('-jar-with-dependencies', ''),
        sha256=str(zeps_core.read_hexhash('sha256'))
    )
