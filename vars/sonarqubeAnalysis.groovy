def call(Map config = [:]) { 
      withSonarQubeEnv('sonarqube') {
	   sh 'mvn sonar:sonar \
	      -Dsonar.projectKey=demo \
	      -Dsonar.host.url=http://3.80.120.47:9000 \
	      -Dsonar.login=sqp_63d7c854c48b3df498b864e3be7e5ce26b3245b0'
     }   
}





