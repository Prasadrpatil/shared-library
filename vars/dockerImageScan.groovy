def call(Map config = [:]) {
         sh 'trivy image --format json --output docker-image-scan.json ${registry}:${BUILD_NUMBER}'
}
