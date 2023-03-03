def call() {
  def script = libraryResource('demo.py')
  sh "python3 ${script}"
}
