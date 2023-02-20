import git

repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'
directory = '/repo'

repo = git.Repo.clone_from(repo_url, directory)
