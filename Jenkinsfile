pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from version control (e.g., Git)
                git branch: 'master', url: 'https://github.com/SzabolcsBeko/hello-world-jenkins.git'
            }
        }

        stage('Build & Generate Jar') {
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

        //stage('Publish Results') {
            //steps {
                // Publish JUnit test results to Jenkins
                // junit '**/target/test-classes/*.xml'  Adjust the path as per your test results location
            //}
         //}
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
