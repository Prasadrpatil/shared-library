def call(Map config = [:]) {
       docker.withRegistry( '', registryCredential ) {
	       echo config.dockerImage
	       config.dockerImage.push()
	}
}
