node {
    stage('Prepare') {
        checkout scm;

        def environment = docker.build 'rust'

        environment.inside {
            stage('Clean') {
                sh 'cargo clean'
            }

            stage('Build') {
                sh 'cargo build'
            }

            stage('Test') {
                sh 'cargo test'
            }
        }
    }
}
