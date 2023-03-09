import json
import os
from elasticsearch import Elasticsearch

with open('docker-image-scan.json', 'r') as f:
    # data1 = f.read().strip() 
    log_data = json.load(f)


filtered_log_list = []

# Opening the json file
# with open('trivy.json') as f:
#     log_data = json.load(f)

filtered_log_list.append({
        'ArtifactName': log_data['ArtifactName'],
        'ArtifactType': log_data['ArtifactType']         
    })
    
# filterd data and append on list
for i in range(0, len(log_data['Results'])):
    for j in range(0, len(log_data['Results'][i]['Vulnerabilities'])):
        if 'PublishedDate' in log_data['Results'][i]['Vulnerabilities'][j]:
                    if j > 0:
                        filtered_log_list.append(
                        {
                            'VulnerabilityID': log_data['Results'][i]['Vulnerabilities'][j]['VulnerabilityID'],
                            # 'Target' : log_data['Results'][i]['Vulnerabilities'][j]['Target'],
                            'Description': log_data['Results'][i]['Vulnerabilities'][j]['Description'],
                            'Severity': log_data['Results'][i]['Vulnerabilities'][j]['Severity'],
                            'PublishedDate' : log_data['Results'][i]['Vulnerabilities'][j]['PublishedDate'],
                            'LastModifiedDate' : log_data['Results'][i]['Vulnerabilities'][j]['LastModifiedDate']
                        }
                        )
        else:
            continue   

#duming the list on the json file
with open('dump_trivy.json','w') as f:
        # json.dump(filtered_log_list,f)
        json.dump(filtered_log_list,f)
#closing the opened file
f.close()

es = Elasticsearch(['http://3.91.216.82:9200'])

with open('dump_trivy.json', 'r') as f:
    # data1 = f.read().strip() 
    data = json.load(f)

for doc in data:
    res = es.index(index="docker-image-scanning", body=doc)

print("DATA IS PUSHED TO ELASTICSEARCH !!!")
