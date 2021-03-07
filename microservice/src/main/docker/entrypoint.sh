#!/bin/sh
echo "Dockerizando aplicação MICROSERVICE por Dockerfile"
exec java -jar "/home/spring-boot-cloud-netflix/microservice.war"
