# SPRING CLOUD NETFLIX

## Requisitos
  - Java 8
  - Docker

## Desenvolvimento

Para iniciar a aplicação execute:

```
sudo docker-compose -f ./microservice/src/main/docker/mysql.yml up
./mvnw clean package em microservice, gateway e registry
./mvnw em microservice, gateway e registry
```
