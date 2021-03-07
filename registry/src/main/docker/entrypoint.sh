#!/bin/sh
echo "Dockerizando aplicação EUREKAREGISTRY por Dockerfile"
exec java -jar "/home/spring-boot-cloud-netflix/eureka-registry.war"
