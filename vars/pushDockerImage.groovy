def call(Map config = [:]) {
       dockerImage=config.dockerImage
       echo dockerImage
//        docker.withRegistry( '', registryCredential ) {
// 	       docker.image(dockerImage).push()
// 	}
}
