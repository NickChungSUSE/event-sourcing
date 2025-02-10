package com.neu.eventsourcing.command.main.config;

import com.neu.eventsourcing.command.infrastructure.EventJpaRepository;
import com.neu.eventsourcing.command.infrastructure.EventRepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
    "com.neu.eventsourcing.command.infrastructure",
    "org.axonframework.eventhandling.tokenstore",
    "org.axonframework.modelling.saga.repository",
    "org.axonframework.eventsourcing.eventstore"
})
@EntityScan(basePackages = {
    "com.neu.eventsourcing.command.infrastructure.entity",
    "org.axonframework.eventhandling.tokenstore.jpa",
    "org.axonframework.modelling.saga.repository.jpa",
    "org.axonframework.eventsourcing.eventstore.jpa"
})
public class EventConfig {

  @Bean
  public EventRepositoryImpl eventRepositoryImpl(EventJpaRepository eventJpaRepository) {
    return new EventRepositoryImpl(eventJpaRepository);
  }
}
