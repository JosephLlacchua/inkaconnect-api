FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/INKACONNECT-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_inkaconnect.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api_inkaconnect.jar"]