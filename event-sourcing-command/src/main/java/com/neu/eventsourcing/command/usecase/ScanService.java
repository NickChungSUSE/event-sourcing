package com.neu.eventsourcing.command.usecase;

import com.neu.eventsourcing.command.infrastructure.EventGateway;
import com.neu.eventsourcing.command.usecase.data.command.StartScanCommand;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ScanService {

  private static final Logger logger = LoggerFactory.getLogger(ScanService.class);
  private static final String COMMAND_TOPIC = "scan-commands";

  private final EventGateway eventGateway;

  public ScanService(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  public void startScan() {
    String correlationId = UUID.randomUUID().toString();
    StartScanCommand command = new StartScanCommand(correlationId);
    eventGateway.publish(COMMAND_TOPIC, correlationId, command);
  }
}

