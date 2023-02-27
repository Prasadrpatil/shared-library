def call(Map config = [:]) {
         sh 'trivy image --format json --output trivy-result.json ${registry}:${BUILD_NUMBER}'
}
