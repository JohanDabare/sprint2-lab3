pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                dir('starter') {
                    sh 'mvn -B clean package'
                }
            }
        }

        stage('Build Image') {
            steps {
                dir('starter') {
                    sh 'docker build -t team-skeleton .'
                }
            }
        }

        stage('Smoke Test') {
            steps {
                sh 'docker run --rm team-skeleton'
            }
        }
    }
}