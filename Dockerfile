FROM openjdk:17-jdk-slim
LABEL authors="AS221S5_T06"
RUN apt-get update && apt-get install -y \
    libasound2 \
    && rm -rf /var/lib/apt/lists/*
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
