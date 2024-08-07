# Etapa de construcción
FROM openjdk:22-jdk-slim AS build
WORKDIR /app
COPY mvnw .
COPY pom.xml .
COPY src ./src
RUN chmod +x mvnw && ./mvnw package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:22-jre-slim
WORKDIR /app
ARG PORT=8080
ENV PORT=${PORT}
COPY --from=build /app/target/*.jar app.jar
RUN useradd -ms /bin/bash runtime
USER runtime
EXPOSE ${PORT}
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]