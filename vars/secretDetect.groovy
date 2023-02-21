def call(Map config = [:]) {
         
     sh 'trufflehog --no-update filesystem --directory=/var/lib/jenkins/workspace/Devsecops-Pipeline/ --debug --json > trufflehog.json'
}
