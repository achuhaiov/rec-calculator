Overview:
Implemented with base filter parameters, good scalable for adding another parameters, repositories etc.


Postman collection: 
rec-calculator/rec-calculator.postman_collection.json


Database:
Input json-files need to be imported into mongoDB.
Set connection properties here src/main/resources/application.yml



Test Scenario (see in Postman collection):

country “COTE D’IVOIRE” and “NOT LIFE” Company type


Result:
[
{
"references": "BCP-9-5688/k/2020/CICARE",
"country": "COTE D'IVOIRE",
"cedants": "Paix Assur",
"validationStatus": "Partial Verified",
"confirmationStatus": "Confirmed",
"publicationDate": "2020-10-31 15:26:39",
"branch": "TRANSPORTS",
"calculatedREC": 64304885.88
},
{
"references": "BCP-6-5688/k/2020/CICARE",
"country": "COTE D'IVOIRE",
"cedants": "Paix Assur",
"validationStatus": "Partial Verified",
"confirmationStatus": "Confirmed",
"publicationDate": "2020-10-31 15:14:41",
"branch": "TRANSPORTS",
"calculatedREC": 109322460.00
},
{
"references": "BCP-1-AAA01/EY/2020/CICARE",
"country": "COTE D'IVOIRE",
"cedants": "HYPER NON VIE ASSURANCE",
"validationStatus": "Verified",
"confirmationStatus": "Confirmed",
"publicationDate": "2020-10-26 15:06:46",
"branch": "Automobile",
"calculatedREC": 3620209.32
},
{
"references": "BCP-6-AAA01/JK/2020/CICARE",
"country": "COTE D'IVOIRE",
"cedants": "HYPER NON VIE ASSURANCE",
"validationStatus": "Verified",
"confirmationStatus": "Confirmed",
"publicationDate": "2020-11-10 16:12:17",
"branch": "Transports Terrestres",
"calculatedREC": 60044.04
},
{
"references": "BCP-2-9102/ey/2020/CICARE",
"country": "COTE D'IVOIRE",
"cedants": "KIED Assur",
"validationStatus": "Verified",
"confirmationStatus": "Confirmed",
"publicationDate": "2020-11-16 11:43:22",
"branch": "Caution et Credit",
"calculatedREC": 11276.28
}
]
