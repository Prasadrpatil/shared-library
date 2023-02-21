def call(Map config = [:]) {
         sh ' trufflehog --no-update filesystem --directory=config.directory --debug --json > trufflehog.json '
}
