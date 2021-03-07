FROM openjdk:8-jre-alpine

WORKDIR /home/spring-boot-cloud-netflix

ADD ./gateway/src/main/docker/entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown root:root entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080

ADD ./gateway/target/gateway.war gateway.war

