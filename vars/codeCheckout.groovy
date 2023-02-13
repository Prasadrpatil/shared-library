def call(Map config = [:]) {
    checkout([$class: 'GitSCM',
        branches: [[name: config.branch]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[credentialsId: config.credentialsId,
                            url: config.repository]]
    ])
}
