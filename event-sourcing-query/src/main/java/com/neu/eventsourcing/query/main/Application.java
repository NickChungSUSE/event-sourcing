package com.neu.eventsourcing.query.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication(scanBasePackages = "com.neu.eventsourcing.query")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}