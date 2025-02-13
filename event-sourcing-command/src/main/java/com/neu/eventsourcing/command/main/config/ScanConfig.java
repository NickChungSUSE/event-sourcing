package com.neu.eventsourcing.command.main.config;

import com.neu.eventsourcing.command.adapter.controller.ScanController;
import com.neu.eventsourcing.command.adapter.handler.NetworkActivityEventHandler;
import com.neu.eventsourcing.command.adapter.handler.ScanEventHandler;
import com.neu.eventsourcing.command.infrastructure.EventGateway;
import com.neu.eventsourcing.command.usecase.EventService;
import com.neu.eventsourcing.command.usecase.ScanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScanConfig {

  @Bean
  public ScanController scanController(ScanService scanService) {
    return new ScanController(scanService);
  }

  @Bean
  public ScanEventHandler scanEventHandler(EventService eventService) {
    return new ScanEventHandler(eventService);
  }

  @Bean
  public ScanService scanService(EventGateway eventGateway) {
    return new ScanService(eventGateway);
  }
}
