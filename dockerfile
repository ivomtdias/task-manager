# Use a base image with Java and Gradle installed
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

# Copy the Gradle wrapper files
COPY gradle gradle

# Copy the application source code
COPY src src

# Update gradlew permissions
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build --no-daemon

# Expose the application port
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "build/libs/task-manager.jar"]