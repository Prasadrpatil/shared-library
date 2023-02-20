import git
import argparse

parser.add_argument('repository_url', type=str, help='The URL of the Git repository to clone')
parser.add_argument('target_directory', type=str, help='The target directory for the cloned repository')
args = parser.parse_args()

# repo_url = 'https://github.com/Prasadrpatil/java-calculator.git'
# directory = '/repo'

repo = git.Repo.clone_from(repository_url, target_directory)
