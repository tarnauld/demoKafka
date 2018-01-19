pipeline {

  def app

  stage('Checkout') {
    checkout scm
  }

  stage('Build') {

    dir('java') {
      sh 'chmod +x gradlew'
      sh './gradlew clean build'
    }
  }

  stage('Build Docker Image') {
    
    dir('java') {
      app = docker.build("devops/kafka-java")
    }
  }

  stage('Publish To Docker Registry') {

    docker.withRegistry('http://192.168.56.210:5000') {
        app.push("${env.BUILD_NUMBER}")
        app.push("latest")
    }
  }
}