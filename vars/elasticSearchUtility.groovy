def call() {
pythonContent = libraryResource('dockerImageScan.py')

writeFile(file: 'dockerImageScan.py', text: pythonContent)
sh('chmod +x dockerImageScan.py')
sh('/usr/bin/python3 dockerImageScan.py')
}
