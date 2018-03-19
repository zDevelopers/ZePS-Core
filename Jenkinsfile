pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        checkout scm
        sh 'mvn clean install'
        archiveArtifacts(artifacts: '**/target/*.jar', fingerprint: true)
      }
    }
  }
}
