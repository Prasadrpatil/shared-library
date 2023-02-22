def call(Map config = [:]) {
         
         sh 'pwd'
         sh 'whispers . > whipsers.json'
//      sh 'trufflehog --no-update filesystem --directory=/var/lib/jenkins/workspace/Devsecops-Pipeline/ --debug --json > trufflehog.json'
}
