pipeline {
   agent none
   environment {
        registry = "paleontolog/dev_ops"
        registryCredential = 'dockerhub'
   }
    stages {
         stage('Build') {
            agent {
                docker { 
                    image 'maven:3-alpine' 
                    args '-v $HOME/.m2:/root/.m2'
                }
            } 
            steps {
              git branch: 'master', credentialsId: 'github', url: 'https://github.com/Paleontolog/DevOpsSpringHelloWorld.git'
              sh 'ls'
              sh 'mvn --version'
              sh 'mvn clean package'
              sh 'ls'
              stash includes: 'target/**', name: 'compiledJAR'
              stash includes: 'Dockerfile', name: 'dockerfile'
            }
        }
        stage('Example') {
             agent {
                    node { label 'master' } 
                }
                 
                steps {
        
                    unstash 'dockerfile'
                    unstash 'compiledJAR'
                    sh 'ls'
                    script {
                        def dockerHome = tool 'myDocker'
                             
                        env.PATH = "${dockerHome}/bin:${env.PATH}"
                        def myDocker = docker.build("${registry}:${env.BUILD_ID}")
                        docker.withRegistry('', registryCredential ) {
                             myDocker.push()
                        }     
                        sh "docker rmi ${registry}:${env.BUILD_ID}"
                    }
               }
        }
    }
}

