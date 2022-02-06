pipeline {
    agent any
	
	  tools
    {
       maven "Maven"
    }
    
  environmrnt {
    DOCKERHUB_CREDENTIALS = credentials('yassine-dockerhub')
  }
  
 stages {
      stage('checkout') {
           steps {
             
                git branch: 'JPA', url: 'https://github.com/yassineYAYAbouzar/JAVA-EE-Gestion-des-employ-s'
             
          }
        }
	 stage('Execute Maven') {
           steps {
             
                sh 'mvn package'             
          }
        }
        

  stage('Docker Build and Tag') {
           steps {
              
                sh 'docker build -t samplewebapp:latest .' 
                sh 'docker tag gestionemployee yassinebouzar/gestion-employee:latest'
                //sh 'docker tag samplewebapp nikhilnidhi/samplewebapp:$BUILD_NUMBER'
               
          }
        }
 stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
 }
  stage('Publish image to Docker Hub') {
          
          steps {
              sh  'docker push yassinebouzar/gestion-employee:latest'      
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
			{
                sh "docker run -d -p 8003:8080 yassinebouzar/gestion-employee"
 
            }
        }
       
       post{
         always {
             sh 'docker logout'
         }
       }

	}
    
