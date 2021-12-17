# MicroService : Consumer monaco telecom

Small exemple of consumer which consume a ServiceMonaco object : {tag:"tag22",action:"ACTIVE"} and call a other microservice using Rest API

## Docker

**launch at dockerfile level this commande for build the image docker:**
docker build -t consumer-docker .

**lauch image docker :**
docker run --hostname consumer  -p 63288:63288  --network="host" consumer-docker
docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management