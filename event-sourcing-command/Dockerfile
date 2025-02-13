FROM registry.suse.com/bci/openjdk:17

WORKDIR /app

COPY build/libs/event-sourcing-command-1.0.0.jar event-sourcing-command.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/event-sourcing-command.jar"]