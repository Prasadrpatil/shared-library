import os
import git

directory = '/repo'

if not os.path.exists(directory):
    os.makedirs(directory)
else:
    print(f"The directory '{directory}' already exists.")

repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'

repo = git.Repo.clone_from(repo_url, directory)
