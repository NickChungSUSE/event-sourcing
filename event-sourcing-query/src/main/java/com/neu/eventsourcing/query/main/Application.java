package com.neu.eventsourcing.query.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@SpringBootApplication(scanBasePackages = "com.neu.eventsourcing.query")
@EnableJpaRepositories(basePackages = "com.neu.eventsourcing.query.infrastructure")
@EntityScan(basePackages = {"com.neu.eventsourcing.query.infrastructure.entity",
    "org.axonframework.eventsourcing.eventstore.jpa"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}