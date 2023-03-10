def call(Map config = [:]) { 
      withSonarQubeEnv('sonarqube') {
           sh 'mvn sonar:sonar \
              -Dsonar.projectKey=java-proj \
              -Dsonar.host.url=http://34.207.149.238:9000 \
              -Dsonar.login=sqp_e025a02e02bffe81d48161d1accf1219ff79f659'
      }
}





