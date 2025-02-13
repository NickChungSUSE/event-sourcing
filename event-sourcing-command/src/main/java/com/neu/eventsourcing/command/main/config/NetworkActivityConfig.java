package com.neu.eventsourcing.command.main.config;

import com.neu.eventsourcing.command.adapter.controller.NetworkActivityController;
import com.neu.eventsourcing.command.adapter.handler.NetworkActivityEventHandler;
import com.neu.eventsourcing.command.infrastructure.EventGateway;
import com.neu.eventsourcing.command.usecase.EventService;
import com.neu.eventsourcing.command.usecase.NetworkActivityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkActivityConfig {

  @Bean
  public NetworkActivityController networkActivityController(
      NetworkActivityService networkActivityService) {
    return new NetworkActivityController(networkActivityService);
  }

  @Bean
  public NetworkActivityEventHandler networkActivityEventHandler(EventService eventService) {
    return new NetworkActivityEventHandler(eventService);
  }

  @Bean
  public NetworkActivityService networkActivityService(EventGateway eventGateway) {
    return new NetworkActivityService(eventGateway);
  }
}
