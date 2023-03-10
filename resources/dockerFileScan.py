import json
import os
from elasticsearch import Elasticsearch

with open('dockerfile-scan.json', 'r') as f:
    # data1 = f.read().strip() 
    log_data = json.load(f)


filtered_log_list = []

# Opening the json file
# with open('trivy.json') as f:
#     log_data = json.load(f)

filtered_log_list.append({
        'ArtifactName': log_data['ArtifactName'],         
    })
    
# filterd data and append on list
for i in range(0, len(log_data['Results'])):
    for j in range(0, len(log_data['Results'][i]['Misconfigurations'])):
        filtered_log_list.append(
                        {
                            'Title': log_data['Results'][i]['Misconfigurations'][j]['Title'],
                            # 'Target' : log_data['Results'][i]['Vulnerabilities'][j]['Target'],
                            'Description': log_data['Results'][i]['Misconfigurations'][j]['Description'],
                            'Severity': log_data['Results'][i]['Misconfigurations'][j]['Severity'],
                            'Resolution' : log_data['Results'][i]['Misconfigurations'][j]['Resolution'],
                            'Message' : log_data['Results'][i]['Misconfigurations'][j]['Message'],
                            'Reference' : log_data['Results'][i]['Misconfigurations'][j]['References'],
                            'Status' : log_data['Results'][i]['Misconfigurations'][j]['Status']
                        }
                        ) 
print(filtered_log_list)
#duming the list on the json file
with open('dockerfile-Scanningdump.json','w') as f:
        # json.dump(filtered_log_list,f)
        json.dump(filtered_log_list,f)
#closing the opened file
f.close()

es = Elasticsearch(['http://54.160.190.97:9200'])

with open('dockerfile-Scanningdump.json', 'r') as f:
#     # data1 = f.read().strip() 
     data = json.load(f)

for doc in data:
    res = es.index(index="docker-file-scanning", body=doc)
    
print("DATA IS PUSHED TO ELASTICSEARCH !!!")
