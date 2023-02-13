def call(Map config = [:]) {
    switch (config.buildTool) {
        case 'maven':
            switch (config.artifactType) {
                case 'jar':
                    sh "mvn clean install -Dmaven.test.skip=true"
                    break
                case 'war':
                    sh "mvn clean install -Dmaven.test.skip=true -P war"
                    break
                default:
                    println "Error: Invalid artifact type. Must be 'jar' or 'war'."
            }
            break
        case 'gradle':
            switch (config.artifactType) {
                case 'jar':
                    sh "gradle build"
                    break
                case 'war':
                    sh "gradle war"
                    break
                default:
                    println "Error: Invalid artifact type. Must be 'jar' or 'war'."
            }
            break
        case 'ant':
            switch (config.artifactType) {
                case 'jar':
                    sh "ant jar"
                    break
                case 'war':
                    sh "ant war"
                    break
                default:
                    println "Error: Invalid artifact type. Must be 'jar' or 'war'."
            }
            break
        case 'dotnet':
            switch (config.artifactType) {
                case 'exe':
                case 'dll':
                    sh "dotnet build -c Release -r linux-x64"
                    break
                default:
                    println "Error: Invalid artifact type. Must be 'exe' or 'dll'."
            }
            break
        case 'node':
            switch (config.artifactType) {
                case 'js':
                    sh "npm run build"
                    break
                default:
                    println "Error: Invalid artifact type. Must be 'js'."
            }
            break
        default:
            println "Error: Invalid build tool. Must be 'maven', 'gradle', 'ant', 'dotnet', or 'node'."
    }
}
