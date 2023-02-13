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
                    sh "dotnet build -c Release"
                    break
                case 'dll':
                    sh "dotnet build -c Release"
                    break
                default:
                    println "Error: Invalid artifact type. Must be 'exe' or 'dll'."
            }
            break
        default:
            println "Error: Invalid build tool. Must be 'maven', 'gradle', 'ant', or 'dotnet'."
    }
}
