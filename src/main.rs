extern crate zeps;
extern crate failure;

use std::io::Write;
use failure::Error;
use zeps::data::universe::Universe;

fn print_error(e: &Error) {
    let seriously_dude = "Unable to write to standard error output (stderr)!";
    let stderr = &mut ::std::io::stderr();
    let mut stderr = stderr.lock();

    writeln!(stderr, " [!] Error: {}", e).expect(seriously_dude);

    for cause in e.causes().skip(1) {
        writeln!(stderr, "  |  Cause: \t{}", cause).expect(seriously_dude);
    }

    if cfg!(debug_assertions) {
        writeln!(stderr, "\n\n [?] Backtrace: {:#?}", e.backtrace()).expect(seriously_dude);
    }
}


fn main() {
    if let Err(ref e) = run() {
        print_error(e);
        ::std::process::exit(1);
    }
}

fn run() -> Result<(), Error> {
    let u: Universe = zeps::read_universe_from_file("./tests/fixtures/with_data.json")?;
    let s: Vec<_> = u.stations().collect();
    println!("Stations: {:#?}", s);
    Ok(())
}
