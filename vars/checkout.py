#!/usr/bin/env python
import git

repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'
repo_path = ''

repo = git.Repo.clone_from(repo_url, repo_path)
