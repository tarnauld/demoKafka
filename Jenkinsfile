pipeline{
	agent any
	stages {
		stage("first stage") {
			steps {
				echo "Building..."
				cd demoKafka
				./gradlew build
			}
		}
	}
}