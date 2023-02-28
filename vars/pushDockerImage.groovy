def call(Map config = [:]) {
       dockerImage=config.dockerImage
       echo $dockerImage
       docker.withRegistry( '', registryCredential ) {
	       config.dockerImage.push()
	}
}
