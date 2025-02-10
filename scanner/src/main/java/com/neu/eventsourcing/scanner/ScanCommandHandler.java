package com.neu.eventsourcing.scanner;

import com.neu.eventsourcing.scanner.command.StartScanCommand;
import com.neu.eventsourcing.scanner.event.ScanCompletedEvent;
import com.neu.eventsourcing.scanner.event.ScanFailedEvent;
import com.neu.eventsourcing.scanner.event.ScanProgressEvent;
import com.neu.eventsourcing.scanner.event.ScanStartedEvent;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ScanCommandHandler {

  private static final Logger logger = LoggerFactory.getLogger(ScanCommandHandler.class);

  private static final String SCAN_STARTED_TOPIC = "ScanStarted";
  private static final String SCAN_PROGRESS_TOPIC = "ScanProgress";
  private static final String SCAN_FAILED_TOPIC = "ScanFailed";

  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  @KafkaListener(topics = "scan-commands", groupId = "scan-group")
  public void handleStartScanCommand(@Payload StartScanCommand command) {
    try {
      processCommand(command);

      // Publish started event
      ScanStartedEvent startedEvent = new ScanStartedEvent(command.getScanId());
      publishEvent(SCAN_STARTED_TOPIC, command.getScanId(), startedEvent);

      Thread.sleep(500);
      ScanProgressEvent progressEvent = new ScanProgressEvent(command.getScanId());
      publishEvent(SCAN_PROGRESS_TOPIC, command.getScanId(), progressEvent);

      Thread.sleep(500);
      ScanCompletedEvent completedEvent = new ScanCompletedEvent(command.getScanId());
      publishEvent(SCAN_PROGRESS_TOPIC, command.getScanId(), completedEvent);

    } catch (Exception e) {
      logger.error("Failed to process scan command for ID: {}", command.getScanId(), e);
      ScanFailedEvent failedEvent = new ScanFailedEvent(command.getScanId(), e.getMessage(),
          LocalDateTime.now());
      publishEvent(SCAN_FAILED_TOPIC, command.getScanId(), failedEvent);
    }
  }

  private void publishEvent(String topic, String key, Object event) {
    kafkaTemplate.send(topic, key, event).whenComplete((result, ex) -> {
      if (ex == null) {
        logger.info("Successfully published event to {} for scan ID: {}", topic, key);
      } else {
        logger.error("Failed to publish event to {} for scan ID: {}", topic, key, ex);
      }
    });
  }

  private void processCommand(StartScanCommand command) {
    logger.info("Processing scan command: {}", command.getScanId());
  }
}



