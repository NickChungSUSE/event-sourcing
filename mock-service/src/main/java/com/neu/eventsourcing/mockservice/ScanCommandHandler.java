package com.neu.eventsourcing.mockservice;

import com.neu.eventsourcing.mockservice.command.StartScanCommand;
import com.neu.eventsourcing.mockservice.event.ScanCompleted;
import com.neu.eventsourcing.mockservice.event.ScanFailed;
import com.neu.eventsourcing.mockservice.event.ScanProgress;
import com.neu.eventsourcing.mockservice.event.ScanStarted;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ScanCommandHandler {

  private static final Logger logger = LoggerFactory.getLogger(ScanCommandHandler.class);

  private static final String SCAN_STARTED_TOPIC = "ScanStarted";
  private static final String SCAN_PROGRESS_TOPIC = "ScanProgress";
  private static final String SCAN_COMPLETED_TOPIC = "ScanCompleted";
  private static final String SCAN_FAILED_TOPIC = "ScanFailed";

  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  @KafkaListener(topics = "scan-commands", groupId = "scan-group")
  public void handleStartScanCommand(@Payload StartScanCommand command) {
    try {
      processCommand(command);
    } catch (Exception e) {
      logger.error("Failed to process scan command for ID: {}", command.getScanId(), e);
      ScanFailed failedEvent = new ScanFailed(command.getScanId(), e.getMessage(),
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

  private void processCommand(StartScanCommand command) throws InterruptedException {
    logger.info("Processing scan command: {}", command.getScanId());

    ScanStarted startedEvent = new ScanStarted(command.getScanId());
    publishEvent(SCAN_STARTED_TOPIC, command.getScanId(), startedEvent);

    Thread.sleep(500);
    ScanProgress progressEvent = new ScanProgress(command.getScanId());
    publishEvent(SCAN_PROGRESS_TOPIC, command.getScanId(), progressEvent);

    Thread.sleep(500);
    ScanCompleted completedEvent = new ScanCompleted(command.getScanId());
    publishEvent(SCAN_COMPLETED_TOPIC, command.getScanId(), completedEvent);
  }
}



