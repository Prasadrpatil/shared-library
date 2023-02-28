def call(Map config = [:]) {
       docker.withRegistry( '', registryCredential ) {
              dockerImage = docker.image(config.imageName)
              dockerImage.push()
	}
}
