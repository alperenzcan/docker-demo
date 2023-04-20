# FROM eclipse-temurin:17-jdk-focal
 
# WORKDIR /app
 
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# RUN ./mvnw dependency:go-offline
 
# COPY src ./src
 
# CMD ["./mvnw", "spring-boot:run"]



# FROM openjdk:17-alpine
 
# WORKDIR /app
 
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# RUN chmod +x mvnw && ./mvnw dependency:go-offline
# COPY src ./src
 
# CMD ["./mvnw", "spring-boot:run"]



# 372MB
FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests
 
# Runtime Image
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]