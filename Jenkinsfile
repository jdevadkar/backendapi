pipeline{
 	agent any
 	stages{
 		stage ('Compile Stage'){
 			steps {
 				withMaven(maven : 'Maven'){
 				bat 'mvn clean compile'
 				}
 			}
 		}
 		
 		stage ('Testing Stage'){
 			steps {
 				withMaven(maven : 'Maven'){
 				bat 'mvn clean test'
 				}
 			}
 		}
 		
 		stage ('Deployment Stage'){
 			steps {
 				withMaven(maven : 'Maven'){
 				bat 'mvn clean deploy'
 				}
 			}
 		}
 	
 	}
}