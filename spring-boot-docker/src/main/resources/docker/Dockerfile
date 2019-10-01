FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-boot-docker-1.0.jar app.jar
ENTRYPOINT ["java", "-Djava.ecurity.egd=file:/dev/./urandom", "-jar", "/app.jar"]