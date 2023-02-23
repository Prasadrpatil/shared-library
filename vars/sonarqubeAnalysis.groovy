def call(Map config = [:]) { 
      withSonarQubeEnv('sonarqube') {
           sh 'mvn sonar:sonar \
              -Dsonar.projectKey=java-proj \
              -Dsonar.host.url=http://34.204.48.11:9000 \
              -Dsonar.login=sqp_52499f71b8b08f675069c9af576ad1aa465f0b04'
      }
}





