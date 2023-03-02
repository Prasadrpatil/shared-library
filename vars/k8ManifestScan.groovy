def call(Map config = [:]) {
         sh 'kubesec scan deployment.yaml --output k8-manifest-scan.json --exit-code 0'
}
