pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK17', type: 'ToolJava'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    tools {
        maven 'Maven 3' // Assumes Maven is installed and set up in Jenkins
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
                // Make sure Java is available, just to confirm JAVA_HOME is set
                    sh 'echo $JAVA_HOME'
                
                // Run build commands
                script {
                    sh './mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven
                script {
                    sh './mvn test'
                }
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
