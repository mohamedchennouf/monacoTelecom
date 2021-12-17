# MicroService : Supplier monaco telecom

Small exemple of supplier which send a ServiceMonaco object : {tag:"tag22",action:"ACTIVE"}

## Docker

**launch at dockerfile level this commande for build the image docker:**
docker build -t supplier-docker .

**lauch image docker :**
docker run --hostname supplier  -p 63244:63244  --network="host" supplier-docker
docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
