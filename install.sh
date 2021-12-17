
docker pull bitnami/rabbitmq:latest
cd service-management
docker build -t monaco-service-docker .
cd ../consumer
docker build -t consumer-docker .
cd ../supplier
docker build -t supplier-docker .
#docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
#docker run -dp 8080:8080  --network="host" monaco-service-docker
#docker run --hostname consumer  -p 63288:63288  --network="host" consumer-docker
#docker run --hostname supplier  -p 63244:63244  --network="host" supplier-docker
cd ..
docker-compose build



