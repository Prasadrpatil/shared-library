def call(Map config = [:]) {
       docker.withRegistry( '', registryCredential ) {
              dockerImage.push()
	}
}
