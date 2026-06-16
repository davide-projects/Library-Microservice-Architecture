FROM eclipse-temurin:26-jdk-alpine

WORKDIR /app

COPY target/book-service-1.0.0.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]