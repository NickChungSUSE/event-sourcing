package com.neu.eventsourcing.command.main.configuration;

import com.neu.eventsourcing.command.infrastructure.EventJpaRepository;
import com.neu.eventsourcing.command.infrastructure.EventRepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.neu.eventsourcing.command.infrastructure")
@EntityScan(basePackages = "com.neu.eventsourcing.command.infrastructure.entity")
public class EventConfiguration {

  @Bean
  public EventRepositoryImpl eventRepositoryImpl(EventJpaRepository eventJpaRepository) {
    return new EventRepositoryImpl(eventJpaRepository);
  }
}
