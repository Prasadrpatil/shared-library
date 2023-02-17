import git

repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'
repo_path = '/path'

repo = git.Repo.clone_from(repo_url, repo_path)
