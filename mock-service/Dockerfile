FROM registry.suse.com/bci/openjdk:17

WORKDIR /app

COPY build/libs/mock-service-1.0.0.jar mock-service.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/mock-service.jar"]