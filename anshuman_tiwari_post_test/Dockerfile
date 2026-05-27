# Q19 - Dockerfile for a Spring Boot application
FROM eclipse-temurin:21-jre

# Working directory inside the container
WORKDIR /app

# Copy the built jar (located in target/) into the image
COPY target/app.jar app.jar

# The application listens on port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

# ----------------------------------------------------------------------
# Build & run commands:
#
#   docker build -t myapp:latest .
#   docker run -p 8080:8080 myapp:latest
# ----------------------------------------------------------------------
