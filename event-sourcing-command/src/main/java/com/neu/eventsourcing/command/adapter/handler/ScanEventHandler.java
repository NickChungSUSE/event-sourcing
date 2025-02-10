package com.neu.eventsourcing.command.adapter.handler;

import com.neu.eventsourcing.command.adapter.handler.event.ScanCompletedEvent;
import com.neu.eventsourcing.command.adapter.handler.event.ScanFailedEvent;
import com.neu.eventsourcing.command.adapter.handler.event.ScanProgressEvent;
import com.neu.eventsourcing.command.adapter.handler.event.ScanStartedEvent;
import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventhandling.GenericDomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ScanEventHandler {

  private final Logger logger = LoggerFactory.getLogger(ScanEventHandler.class);

  @Autowired
  private EventStore eventStore;

  @KafkaListener(topics = "ScanStarted", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanStartedEvent"})
  private void handleScanStarted(ScanStartedEvent event) {
    logger.info("Scan started with ID: {}", event.getScanId());
    storeEvent(event, event.getScanId());
  }

  @KafkaListener(topics = "ScanProgress", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanProgressEvent"})
  private void handleScanProgress(ScanProgressEvent event) {
    logger.info("Scan progress for ID: {}", event.getScanId());
    storeEvent(event, event.getScanId());
  }

  @KafkaListener(topics = "ScanCompleted", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanCompletedEvent"})
  private void handleScanCompleted(ScanCompletedEvent event) {
    logger.info("Scan completed for ID: {}", event.getScanId());
    storeEvent(event, event.getScanId());
  }

  @KafkaListener(topics = "ScanFailed", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanFailedEvent"})
  private void handleScanFailed(ScanFailedEvent event) {
    logger.error("Scan failed for ID: {} with error: {}", event.getScanId(),
        event.getErrorMessage());
    storeEvent(event, event.getScanId());
  }

  private void storeEvent(Object event, String aggregateId) {
    try {
      DomainEventMessage<?> domainEvent = new GenericDomainEventMessage<>("Scan", aggregateId,
          getNextSequenceNumber(aggregateId), event);

      eventStore.publish(domainEvent);
      logger.info("Event stored successfully for ID: {}", aggregateId);
    } catch (Exception e) {
      logger.error("Failed to store event in Event Store for ID: {}", aggregateId, e);
    }
  }

  private long getNextSequenceNumber(String aggregateId) {
    try {
      return eventStore.readEvents(aggregateId).asStream().count();
    } catch (AggregateNotFoundException e) {
      return 0L;
    }
  }
}

