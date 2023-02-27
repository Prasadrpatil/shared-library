def call(Map config = [:]) {  
      dockerImage = docker.build registry + ":$BUILD_NUMBER"
}
