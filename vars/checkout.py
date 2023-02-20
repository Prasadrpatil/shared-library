import git
import argparse

parser = argparse.ArgumentParser(description='Clone a Git repository')
parser.add_argument('repository_url', type=str)
parser.add_argument('target_directory', type=str)
args = parser.parse_args()

# repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'
# directory = '/repo'

repo = git.Repo.clone_from('https://github.com/Prasadrpatil/java-calculator', '/var/lib/jenkins/workspace/Devsecops-Pipeline/repo')
