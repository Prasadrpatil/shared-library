def call(Map config = [:]) {     
     snykSecurity(
            snykInstallation: 'snyk',
            snykTokenId: 'Snyk-Token',
            failOnIssues: false,
            additionalArguments: '--json-file-output=snyk-report.json'
      )
//      sh 'snyk auth b369ec32-7576-4822-95ca-e59b0cb76dc4'    
//      sh 'snyk test /var/lib/jenkins/workspace/Devsecops-Pipeline/ --json > snyk.json'
}
