pipeline {
    agent {
        docker 'rust:latest'
    }
    stages {
        stage('Prepare') {
            steps {
                checkout scm;
            }
        }

        stage('Clean') {
            steps {
                sh 'cargo clean'
            }
        }

        stage('Build') {
            steps {
                sh 'cargo build'
            }
        }

        stage('Test') {
            steps {
                sh 'cargo test'
            }
        }
    }
}
