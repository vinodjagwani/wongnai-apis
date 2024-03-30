FROM openjdk:17-jdk-slim

EXPOSE 8089
EXPOSE 5005


COPY ./fdelivery-order-service/target/fdelivery-order-service-1.0.0.jar /app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "-Djdk.tls.client.protocols=TLSv1.2", "/app.jar"]


