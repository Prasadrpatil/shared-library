def call(Map config = [:]) {
       docker.withRegistry( '', registryCredential ) {
	       docker.image(config.dockerImage).push()
	}
}
