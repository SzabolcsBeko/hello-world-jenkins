pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        DOCKER_IMAGE = 'maven:3.8.4-openjdk-17'
    }

    tools {
        maven 'Maven 3' // Assumes Maven is installed and set up in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from version control (e.g., Git)
                git branch: 'master', url: 'https://github.com/SzabolcsBeko/hello-world-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                // Run build commands
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Publish Results') {
            steps {
                // Publish JUnit test results to Jenkins
                junit '**/target/test-classes/*.xml'  // Adjust the path as per your test results location
            }
        }

    }

    post {
        always {
            // Clean up if needed
            cleanWs()
        }
        success {
            echo 'Build and tests passed!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
