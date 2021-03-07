FROM openjdk:8-jre-alpine

WORKDIR /home/spring-boot-cloud-netflix

ADD ./microservice/src/main/docker/entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown root:root entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8081

ADD ./microservice/target/microservice.war microservice.war

