package com.neu.eventsourcing.command.usecase;

import com.neu.eventsourcing.command.domain.EventRepository;
import com.neu.eventsourcing.command.usecase.data.command.StartScanCommand;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ScanService {

  private static final Logger logger = LoggerFactory.getLogger(ScanService.class);
  private static final String COMMAND_TOPIC = "scan-commands";

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  public void startScan() {
    String correlationId = UUID.randomUUID().toString();
    StartScanCommand command = new StartScanCommand(correlationId);
    kafkaTemplate.send(COMMAND_TOPIC, correlationId, command).whenComplete((result, ex) -> {
      if (ex == null) {
        logger.info("Command sent successfully to topic: {}", COMMAND_TOPIC);
      } else {
        logger.error("Failed to send command to Kafka", ex);
      }
    });
  }
}

