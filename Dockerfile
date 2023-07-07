FROM openjdk:19-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project's compiled JAR file into the container
COPY target/sirati-mustakim.jar /app/sirati-mustakim.jar

# Expose the port on which your Spring application listens
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "sirati-mustakim.jar"]