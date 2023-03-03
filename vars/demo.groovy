def call() {
pythonContent = libraryResource('demo.py')

writeFile(file: 'demo.py', text: pythonContent)
sh('chmod +x demo.py')
sh('python3 demo.py')
}
