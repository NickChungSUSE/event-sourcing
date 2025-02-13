package com.neu.eventsourcing.mockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication(scanBasePackages = "com.neu.eventsourcing.mockservice")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}