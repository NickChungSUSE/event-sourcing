package com.neu.eventsourcing.command.adapter.handler;

import com.neu.eventsourcing.command.adapter.handler.event.ScanCompleted;
import com.neu.eventsourcing.command.adapter.handler.event.ScanFailed;
import com.neu.eventsourcing.command.adapter.handler.event.ScanProgress;
import com.neu.eventsourcing.command.adapter.handler.event.ScanStarted;
import com.neu.eventsourcing.command.usecase.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ScanEventHandler {

  private static final Logger logger = LoggerFactory.getLogger(ScanEventHandler.class);
  private static final String EVENT_TYPE = "Scan";

  private final EventService eventService;

  public ScanEventHandler(EventService eventService) {
    this.eventService = eventService;
  }

  @KafkaListener(topics = "ScanStarted", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanStarted"})
  private void handleScanStarted(ScanStarted event) {
    logger.info("Scan started with ID: {}", event.getScanId());
    eventService.storeEvent(EVENT_TYPE, event, event.getScanId());
  }

  @KafkaListener(topics = "ScanProgress", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanProgress"})
  private void handleScanProgress(ScanProgress event) {
    logger.info("Scan progress for ID: {}", event.getScanId());
    eventService.storeEvent(EVENT_TYPE, event, event.getScanId());
  }

  @KafkaListener(topics = "ScanCompleted", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanCompleted"})
  private void handleScanCompleted(ScanCompleted event) {
    logger.info("Scan completed for ID: {}", event.getScanId());
    eventService.storeEvent(EVENT_TYPE, event, event.getScanId());
  }

  @KafkaListener(topics = "ScanFailed", groupId = "scan-group", properties = {
      "spring.json.value.default.type=com.neu.eventsourcing.command.adapter.handler.event.ScanFailed"})
  private void handleScanFailed(ScanFailed event) {
    logger.error("Scan failed for ID: {} with error: {}", event.getScanId(),
        event.getErrorMessage());
    eventService.storeEvent(EVENT_TYPE, event, event.getScanId());
  }
}

