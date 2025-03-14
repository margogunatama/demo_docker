pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk'
        PATH = "$JAVA_HOME/bin:$PATH"
        DOCKER_NAME = "demo_docker"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -Dskiptest'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    def imageName = "myapp:${env.BUILD_NUMBER}"
                    sh "docker build -t ${imageName} ."
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def containerName = "myapp-container"
                    sh "docker stop ${containerName} || true"
                    sh "docker rm ${containerName} || true"
                    sh "docker run -d --name ${containerName} -p 8080:8080 myapp:${env.BUILD_NUMBER}"
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
