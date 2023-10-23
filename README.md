# 

```
 # 매입 - 오징어 10마리 
http :8088/purchases accountId[id]="ACC-1" mainShipName="만선호2" purchaseDate="2023-01-01" purchaseDetails[0][itemId]="cuttle fish" purchaseDetails[0][qty]=10

# 매출 - 오징어 5마리
http PUT :8088/purchases/1/sale itemId="cuttle fish" qty=5

# 확인
http :8088/purchases/1     # must be 5 remains for cuttle fish

# 검색
http :8088/purchases/search/findByQueryPur
chase mainShipName=="만선호"


```


## Model
www.msaez.io/#/storming/fisherp

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- master
- purchase
- sales
- inventory


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- master
```
 http :8088/accounts accountName="accountName" representative="representative" businessRegistrationNumber="businessRegistrationNumber" address="address" industry="industry" category="category" customerType="customerType" 
 http :8088/items itemName="itemName" itemCode="itemCode" itemUnit="itemUnit" 
```
- purchase
```
 http :8088/purchases purchaseNo="purchaseNo" purchaseType="purchaseType" purchaseDate="purchaseDate" warehouseArrivalDate="warehouseArrivalDate" storageFeePaymentDate="storageFeePaymentDate" storageFeePaymentStatus="storageFeePaymentStatus" mainShipName="mainShipName" productName="productName" accountId="accountId" purchaseDetails="purchaseDetails" 
```
- sales
```
```
- inventory
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

