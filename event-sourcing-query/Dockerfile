FROM registry.suse.com/bci/openjdk:17

WORKDIR /app

COPY build/libs/event-sourcing-query-1.0.0.jar event-sourcing-query.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/event-sourcing-query.jar"]