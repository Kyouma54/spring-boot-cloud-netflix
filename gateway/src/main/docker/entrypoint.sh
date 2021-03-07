#!/bin/sh
echo "Dockerizando aplicação GATEWAY por Dockerfile"
exec java -jar "/home/spring-boot-cloud-netflix/gateway.war"
