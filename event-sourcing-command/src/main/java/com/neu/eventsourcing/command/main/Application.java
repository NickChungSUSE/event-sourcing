package com.neu.eventsourcing.command.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@SpringBootApplication(scanBasePackages = "com.neu.eventsourcing.command")
@EnableJpaRepositories(basePackages = {"com.neu.eventsourcing.command.infrastructure",
    "org.axonframework.eventhandling.tokenstore", "org.axonframework.modelling.saga.repository",
    "org.axonframework.eventsourcing.eventstore"})
@EntityScan(basePackages = {"com.neu.eventsourcing.command.infrastructure.entity",
    "org.axonframework.eventhandling.tokenstore.jpa",
    "org.axonframework.modelling.saga.repository.jpa",
    "org.axonframework.eventsourcing.eventstore.jpa"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}