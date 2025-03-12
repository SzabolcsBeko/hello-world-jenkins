pipeline {
    agent any

    environment {
        JAVA_HOME = 'D:\\dev\\Java\\jdk-17'
        PATH = "${JAVA_HOME}\\bin:${env.PATH}"
    }

    tools {
        maven 'Maven 3.6.3' // Assumes Maven is installed and set up in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from version control (e.g., Git)
                git 'https://github.com/SzabolcsBeko/hello-world-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                // Run the Maven build
                script {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven
                script {
                    bat 'mvn test'
                }
            }
        }

        stage('Post-Build Actions') {
            steps {
                junit '**/target/test-*.xml'  // Archive test results
            }
        }
    }

    post {
        always {
            // Clean up, notify or any other actions after build completes
            echo 'Cleaning up after build.'
        }
    }
}
