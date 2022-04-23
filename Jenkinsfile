pipeline {
    agent any
    environment{
        DOCKERHUB = credentials('docker-hub')
    }
    stages {
        stage('Build Project') {
            steps {
                bat './mvnw install'
            }
        }
        stage('Maven Test') {
            steps {
                bat './mvnw test'
            }
        }
        stage('Build Docker Image') {
            steps {
                    bat './mvnw package'
                    bat 'docker build --tag eren51/it-hackathon:latest .'
                }
            }
       stage('Push Image to Docker Hub') {
            steps {
                bat "docker login -u=$DOCKERHUB_USR -p=$DOCKERHUB_PSW"
                bat 'docker push eren51/it-hackathon:latest'
                }
            }
       stage('Deploy') {
                   steps {
                       script {
                            kubernetesDeploy(configs: "deployment.yml", kubeconfigId: "minikube_config")
                       }
                   }
               }
    }
}
