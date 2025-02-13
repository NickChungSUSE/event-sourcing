package com.neu.eventsourcing.command.adapter.handler;

import com.neu.eventsourcing.command.adapter.handler.event.NetworkActivityCreated;
import com.neu.eventsourcing.command.infrastructure.EventGateway;
import com.neu.eventsourcing.command.usecase.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NetworkActivityEventHandler {

  private static final Logger logger = LoggerFactory.getLogger(NetworkActivityEventHandler.class);
  private static final String EVENT_TYPE = "network-activity";
  private static final String NETWORK_ACTIVITY_EVENT_TOPIC = "network-activity-events";

  private final EventService eventService;

  public NetworkActivityEventHandler(EventService eventService) {
    this.eventService = eventService;
  }

  @KafkaListener(topics = NETWORK_ACTIVITY_EVENT_TOPIC, groupId = "network-activity-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.NetworkActivityCreated"})
  private void handleScanStarted(NetworkActivityCreated event) {
    logger.info("Network activity created with ID: {}", event.getId());
    eventService.storeEvent(EVENT_TYPE, event, event.getId());
  }
}
