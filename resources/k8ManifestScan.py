import json
from elasticsearch import Elasticsearch


with open("k8-manifest-scan.json") as f:
    log_data=json.load(f)

filtered_log_list = []

# Assume the given JSON list is stored in a variable named "log_data"
# Load the JSON list into a Python list
# log_list = json.loads(log_data)


# Extract the "advise" list from the first dictionary object
advise_list = log_data[0]['scoring']['advise']

# Loop through the "advise" list and extract the desired values
for advise in advise_list:
    id = advise['id']
    selector = advise['selector']
    reason = advise['reason']
    points = advise['points']
    
    # Do something with the extracted values, e.g., print them
    filtered_log_list.append({
        "object" : log_data[0]['object'],
        "fileName" : log_data[0]['fileName'],
        "message" : log_data[0]['message'],
        "id" : id,
        "selecor" : selector,
         "reason" : reason,
         "points" : points
    })

with open('k8s_manifest_scanning_dump.json','w') as f:
    json.dump(filtered_log_list,f)
f.close()

es = Elasticsearch(['http://3.91.216.82:9200'])

with open('k8s_manifest_scanning_dump.json', 'r') as f:
    # data1 = f.read().strip() 
    data = json.load(f)

for doc in data:
    res = es.index(index="k8s-manifest-scanning", body=doc)
    
print("DATA IS PUSHED TO ELASTICSEARCH !!!")
    
