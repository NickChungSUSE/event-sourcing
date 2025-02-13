package com.neu.eventsourcing.query.main.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.eventsourcing.query.adapter.controller.EventController;
import com.neu.eventsourcing.query.domain.EventRepository;
import com.neu.eventsourcing.query.infrastructure.EventJpaRepository;
import com.neu.eventsourcing.query.infrastructure.EventRepositoryImpl;
import com.neu.eventsourcing.query.usecase.EventService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

  @Bean
  public EventController eventController(EventService eventService) {
    return new EventController(eventService);
  }

  @Bean
  public EventService eventService(EventRepository eventRepository) {
    return new EventService(eventRepository);
  }

  @Bean
  public EventRepositoryImpl eventRepositoryImpl(EventJpaRepository eventJpaRepository,
      ObjectMapper objectMapper) {
    return new EventRepositoryImpl(eventJpaRepository, objectMapper);
  }
}
