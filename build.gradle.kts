plugins {
    java
    id("org.springframework.boot") version "3.2.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.ktxdevelopment"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["springCloudVersion"] = "2023.0.0-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.1.0")
//    implementation("org.springframework.boot:spring-boot-starter-amqp:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-integration:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-mail:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("io.micrometer:micrometer-tracing-bridge-brave:1.0.3")
//    implementation("org.apache.kafka:kafka-streams:3.4.0")
//    implementation("org.springframework.cloud:spring-cloud-starter:4.0.1")
//    implementation("org.springframework.cloud:spring-cloud-starter-gateway-mvc")
//    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer:4.0.1")
//    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.0")
//    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:4.0.0")
//    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.0")
//    implementation("com.auth0:java-jwt:4.4.0")
//    implementation("org.springframework.security:spring-security-jwt:1.1.1.RELEASE")

    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    testImplementation("org.springframework.boot:spring-boot-test:3.2.0-SNAPSHOT")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    implementation("com.google.code.gson:gson:2.10.1")

//    implementation("org.springframework.integration:spring-integration-amqp:6.0.2")
    implementation("org.springframework.integration:spring-integration-http:6.0.2")
//    implementation("org.springframework.integration:spring-integration-kafka:6.0.2")
    implementation("org.springframework.integration:spring-integration-mail:6.0.2")
    implementation("org.springframework.integration:spring-integration-security:6.0.2")
//    implementation("org.springframework.kafka:spring-kafka:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.data:spring-data-jpa:3.1.3")
    compileOnly("org.projectlombok:lombok:1.18.26")
    developmentOnly("org.springframework.boot:spring-boot-devtools:3.0.4")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus:1.10.5")
    runtimeOnly("org.postgresql:postgresql:42.5.4")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    implementation("org.springframework.security:spring-security-core:6.1.3")
    implementation("org.springframework.boot:spring-boot-starter-security:3.0.4")
    implementation("org.springframework.security:spring-security-web:6.1.3")
    implementation("org.springframework.security:spring-security-config:6.1.3")

// https://mvnrepository.com/artifact/commons-codec/commons-codec
    implementation("commons-codec:commons-codec:1.16.0")

    // https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-sleuth-zipkin
//    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin:3.1.9")

//    implementation("io.zipkin.reporter2:zipkin-reporter-brave:2.16.3")



    // https://mvnrepository.com/artifact/jakarta.ws.rs/jakarta.ws.rs-api
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")


    testImplementation("org.mockito:mockito-core:5.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
//    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
//    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
//    testImplementation("org.springframework.amqp:spring-rabbit-test:3.0.2")
    testImplementation("org.springframework.integration:spring-integration-test:6.0.2")
//    testImplementation("org.springframework.kafka:spring-kafka-test:3.0.4")
    testImplementation("org.springframework.security:spring-security-test:6.0.2")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
