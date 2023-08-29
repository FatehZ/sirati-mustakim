FROM openjdk:19-jdk-alpine

WORKDIR /app

COPY target/sirati-mustakim.jar /app/sirati-mustakim.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "sirati-mustakim.jar"]