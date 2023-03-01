def call(Map config = [:]) {
         sh 'trivy config Dockerfile --format json --output dockerfile-scan.json'
}
