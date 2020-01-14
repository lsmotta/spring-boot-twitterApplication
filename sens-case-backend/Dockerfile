FROM openjdk:8-jdk-alpine
VOLUME /app
COPY target/sens-socialTwitter-backend-*.jar application.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/application.jar"]

EXPOSE 8080/tcp