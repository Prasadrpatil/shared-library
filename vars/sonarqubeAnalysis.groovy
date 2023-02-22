def call(Map config = [:]) { 
      withSonarQubeEnv('sonarqube') {
	   sh 'mvn sonar:sonar \
	      -Dsonar.projectKey=${config.project} \
	      -Dsonar.host.url=${config.url} \
	      -Dsonar.login=${config.token}'
     }   
}





