node {

  def app

  stage('Checkout') {
    checkout scm
  }

  stage('Build') {
    sh 'chmod +x gradlew'
    sh './gradlew clean build'
  }

  stage('Build Docker Image') {
      app = docker.build("devops/kafka-java")
  }

  stage('Publish To Docker Registry') {
    docker.withRegistry('http://localhost:5000') {
        app.push("${env.BUILD_NUMBER}")
        app.push("latest")
    }
  }
}