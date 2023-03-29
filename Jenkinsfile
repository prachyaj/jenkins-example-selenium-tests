pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
      steps {
        sh 'google-chrome --version'
      }
    }
    stage('Run Tests') {
      steps {
        sh './mvn clean test'
      }
    }
  }
}
