def buildDockerImage(Map config = [:]) {  
      dockerImage = docker.build registry + ":$BUILD_NUMBER"
}

def pushDockerImage(Map config = [:]) {
       docker.withRegistry( '', registryCredential ) {
              dockerImage.push()
	}
}
