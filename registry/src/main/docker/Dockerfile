FROM openjdk:8-jre-alpine

WORKDIR /home/spring-boot-cloud-netflix

ADD ./registry/src/main/docker/entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown root:root entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8761

ADD ./registry/target/eurekaRegistry.war eureka-registry.war

