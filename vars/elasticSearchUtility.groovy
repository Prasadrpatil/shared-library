def dockerImageScan() {
pythonContent = libraryResource('dockerImageScan.py')

writeFile(file: 'dockerImageScan.py', text: pythonContent)
sh('chmod +x dockerImageScan.py')
sh('python3 dockerImageScan.py')
}

def sbomScan() {
pythonContent = libraryResource('sbomScanning.py')

writeFile(file: 'sbomScanning.py', text: pythonContent)
sh('chmod +x sbomScanning.py')
sh('python3 sbomScanning.py')
}

def dockerFileScan() {
pythonContent = libraryResource('dockerFileScan.py')

writeFile(file: 'dockerFileScan.py', text: pythonContent)
sh('chmod +x dockerFileScan.py')
sh('python3 dockerFileScan.py')
}

def k8ManifestScan() {
pythonContent = libraryResource('k8ManifestScan.py')

writeFile(file: 'k8ManifestScan.py', text: pythonContent)
sh('chmod +x k8ManifestScan.py')
sh('python3 k8ManifestScan.py')
}
