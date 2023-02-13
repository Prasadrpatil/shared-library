def call(Map config = [:]) {
    if (config.buildTool == 'maven') {
        if (config.artifactType == 'jar') {
            sh "mvn clean install -Dmaven.test.skip=true"
        } else if (config.artifactType == 'war') {
            sh "mvn clean install -Dmaven.test.skip=true -P war"
        } else {
            
            println "Error: Invalid artifact type. Must be 'jar' or 'war'."
        }
    } else if (config.buildTool == 'gradle') {
        if (config.artifactType == 'jar') {
            sh "gradle build"
        } else if (config.artifactType == 'war') {
            sh "gradle war"
        } else {
            
            println "Error: Invalid artifact type. Must be 'jar' or 'war'."
        }
    } else if (config.buildTool == 'ant') {
        if (config.artifactType == 'jar') {
            sh "ant jar"
        } else if (config.artifactType == 'war') {
            sh "ant war"
        } else {
            
            println "Error: Invalid artifact type. Must be 'jar' or 'war'."
        }
    } else {
        
        println "Error: Invalid build tool. Must be 'maven', 'gradle', or 'ant'."
    }
}
