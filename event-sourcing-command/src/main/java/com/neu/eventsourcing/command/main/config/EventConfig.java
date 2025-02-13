package com.neu.eventsourcing.command.main.config;

import com.neu.eventsourcing.command.infrastructure.EventGatewayImpl;
import com.neu.eventsourcing.command.infrastructure.EventJpaRepository;
import com.neu.eventsourcing.command.infrastructure.EventRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class EventConfig {

  @Bean
  public EventRepositoryImpl eventRepositoryImpl(EventJpaRepository eventJpaRepository) {
    return new EventRepositoryImpl(eventJpaRepository);
  }

  @Bean
  public EventGatewayImpl eventGatewayImpl(KafkaTemplate<String, Object> kafkaTemplate) {
    return new EventGatewayImpl(kafkaTemplate);
  }
}
