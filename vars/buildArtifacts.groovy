def call(Map config = [:]) {
    switch (config.technology) {
        case 'java':
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
                            error "Error: Invalid artifact type. Must be 'jar' or 'war'."
                            break
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
                            error "Error: Invalid artifact type. Must be 'jar' or 'war'."
                            break
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
                            error "Error: Invalid artifact type. Must be 'jar' or 'war'."
                            break
                    }
                    break
                default:
                    error "Error: Invalid build tool. Must be 'maven', 'gradle', or 'ant'."
                    break
            }
            break
        case '.net':
            switch (config.artifactType) {
                case 'dll':
                    sh "dotnet build"
                    break
                case 'exe':
                    sh "dotnet publish -c Release"
                    break
                default:
                    error "Error: Invalid artifact type. Must be 'dll' or 'exe'."
                    break
            }
            break
        case 'node':
            switch (config.buildTool) {
                case 'npm':
                    switch (config.artifactType) {
                        case 'js':
                            sh "npm install"
                            sh "npm run build"
                            break
                        default:
                            error "Error: Invalid artifact type. Must be 'js'."
                            break
                    }
                    break
                case 'yarn':
                    switch (config.artifactType) {
                        case 'js':
                            sh "yarn install"
                            sh "yarn run build"
                            break
                        default:
                            error "Error: Invalid artifact type. Must be 'js'."
                            break
                    }
                    break
                default:
                    error "Error: Invalid build tool. Must be 'npm' or 'yarn'."
                    break
            }
            break
        default:
            error "Error: Invalid technology. Must be 'java', '.net', or 'node'."
            break
    }
}
