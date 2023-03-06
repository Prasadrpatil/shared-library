def call() {
sh 'pip3 install urllib3'
pythonContent = libraryResource('dockerImageScan.py')

writeFile(file: 'dockerImageScan.py', text: pythonContent)
sh('chmod +x dockerImageScan.py')
sh('python3 dockerImageScan.py')
}
