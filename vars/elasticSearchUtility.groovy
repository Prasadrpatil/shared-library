def dockerImageScan() {
// sh 'pip3 install urllib3'
pythonContent = libraryResource('dockerImageScan.py')

writeFile(file: 'dockerImageScan.py', text: pythonContent)
sh('chmod +x dockerImageScan.py')
sh('python3 dockerImageScan.py')
}

def sbomScan() {
// sh 'pip3 install urllib3'
pythonContent = libraryResource('sbomScanning.py')

writeFile(file: 'sbomScanning.py', text: pythonContent)
sh('chmod +x sbomScanning.py')
sh('python3 sbomScanning.py')
}
