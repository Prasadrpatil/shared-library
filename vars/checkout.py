import os
from git import Repo

def git_checkout(url, branch, path):
    """Checkout a Git repository at the specified branch and path."""
    # Construct the full URL of the Git repository.
    full_url = f"{url}#{branch}"

    # Ensure the target directory exists.
    os.makedirs(path, exist_ok=True)

    # Clone or fetch the Git repository.
    if os.path.exists(os.path.join(path, '.git')):
        repo = Repo(path)
        repo.remote().fetch()
    else:
        Repo.clone_from(full_url, path, branch=branch)

    # Checkout the desired branch.
    repo = Repo(path)
    repo.git.checkout(branch)
