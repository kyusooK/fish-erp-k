# API Usages

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

## To-Dos

1. UI 오류 수정
- Value Object 입력시 문제
- 참조데이터에 대한 피커 / 뷰어
- 액션 실행 후 리프래시 안되는

2. UI 추가
- 옵션으로 그리드에서 직접 데이터 추가/편집하는 기능
- 전표(세금 계산서/레포트) 등을 생성하는 기능 (msa ez로 모델만 만들고 vue component 는 chat gpt 로 생성할 수 있음)

3. 


