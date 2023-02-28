def call(Map config = [:]) {
       dockerImage=config.dockerImage
       docker.withRegistry( '', registryCredential ) {
	       docker.image(dockerImage).push()
	}
}
