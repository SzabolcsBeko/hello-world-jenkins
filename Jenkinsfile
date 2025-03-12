pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
		git branch: 'master'
                // Checkout the code from GitHub or any repository
                url: 'https://github.com/SzabolcsBeko/hello-world-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Compile the Java code (Assuming Maven project)
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run the JUnit tests
                    sh 'mvn test'
                }
            }
        }

        stage('Publish Results') {
            steps {
                junit '**/target/test-*.xml' // Publish JUnit test results
            }
        }
    }

    post {
        always {
            // Clean up or notifications can go here
        }

        success {
            echo 'The pipeline has completed successfully!'
        }

        failure {
            echo 'The pipeline has failed.'
        }
    }
}
