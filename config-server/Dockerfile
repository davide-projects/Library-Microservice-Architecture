FROM eclipse-temurin:21-jdk-alpine

RUN apk add --no-cache curl

WORKDIR /app

COPY config-server/target/*.jar app.jar

COPY config-repo /config-repo

EXPOSE 8888

ENV CONFIG_REPO_PATH=file:/config-repo

HEALTHCHECK --start-period=20s --interval=5s --timeout=3s --retries=3 \
  CMD curl -sf http://localhost:8888/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
