FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/car-service-1.0.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8081

