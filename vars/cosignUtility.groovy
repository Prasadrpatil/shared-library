def imageSigning(Map config = [:]) {
      sh 'cosign version'
      docker.withRegistry( '', registryCredential ) {
          sh 'cosign sign --key $COSIGN_PRIVATE_KEY $registry:$BUILD_NUMBER'
      }
}

def imageVerify(Map config = [:]) {
      sh 'cosign verify --key $COSIGN_PUBLIC_KEY $registry:$BUILD_NUMBER'
}





