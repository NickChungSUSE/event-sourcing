package com.neu.eventsourcing.command.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventGatewayImpl implements EventGateway {

  private static final Logger logger = LoggerFactory.getLogger(EventGatewayImpl.class);

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public EventGatewayImpl(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void publish(String topic, String key, Object event) {
    kafkaTemplate.send(topic, key, event).whenComplete((result, ex) -> {
      if (ex == null) {
        logger.info("Event sent successfully to topic: {}", topic);
      } else {
        logger.error("Failed to send event to Kafka", ex);
      }
    });
  }
}
