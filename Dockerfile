FROM openjdk:17-jdk-slim

COPY target/demo-0.0.1-SNAPSHOT.jar demo_docker.jar

EXPOSE 8080

CMD ["java", "-jar", "demo_docker.jar"]
