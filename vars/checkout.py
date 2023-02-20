import git
import argparse

parser = argparse.ArgumentParser(description='Clone a Git repository')
parser.add_argument('repository_url', type=str, help='The URL of the Git repository to clone')
parser.add_argument('target_directory', type=str, help='The target directory for the cloned repository')
args = parser.parse_args()

# repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'
# directory = '/repo'

repo = git.Repo.clone_from('https://github.com/Prasadrpatil/java-calculator', '/var/lib/jenkins/workspace/Devsecops-Pipeline/repo')
