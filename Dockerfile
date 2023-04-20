FROM openjdk:17-alpine

EXPOSE 8080

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} products.jar

ENTRYPOINT ["java","-jar","/products.jar"]