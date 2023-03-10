import json
from elasticsearch import Elasticsearch

filtered_log_list = []

# Opening the json file
with open('sbom-report.json') as f:
    log_data = json.load(f)

for i in range(0,len(log_data['vulnerabilities'])):
    filtered_log_list.append({
        'Title' : log_data['vulnerabilities'][i]['title'],
        'ModuleName' :log_data['vulnerabilities'][i]['moduleName'],
        'creationTime': log_data['vulnerabilities'][i]['creationTime'],
        'severity' : log_data['vulnerabilities'][i]['severity'],
        'severityWithCritical' : log_data['vulnerabilities'][i]['severityWithCritical'],
        'publicationTime' : log_data['vulnerabilities'][i]['publicationTime'],
        'modificationTime': log_data['vulnerabilities'][i]['modificationTime'],
    })
# for policy in log_data['licensesPolicy']['orgLicenseRules'].items():
   
#     print(policy[1]) 

for license_rule in log_data['licensesPolicy']['orgLicenseRules'].values():
     filtered_log_list.append({
        'licenseType': license_rule['licenseType'],
        'severity' : license_rule['severity'],
        'id' : "1"
    })   
with open('snyk_dump.json','w') as f:
        # json.dump(filtered_log_list,f)
        json.dump(filtered_log_list,f)
#closing the opened file
f.close() 
    # for j in range(0, len(log_data['Vulnerabilities'][i])):
    

es = Elasticsearch(['http://54.160.190.97:9200'])

with open('snyk_dump.json', 'r') as f:
    # data1 = f.read().strip() 
    data = json.load(f)

for doc in data:
    res = es.index(index="sbom-scanning-index", body=doc)
    
print("DATA IS PUSHED TO ELASTICSEARCH !!!")
    
