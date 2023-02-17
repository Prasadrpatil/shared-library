import git

repo_url = 'https://github.com/user/repo.git'
repo_path = '/path/to/clone/repo'

repo = git.Repo.clone_from(repo_url, repo_path)
