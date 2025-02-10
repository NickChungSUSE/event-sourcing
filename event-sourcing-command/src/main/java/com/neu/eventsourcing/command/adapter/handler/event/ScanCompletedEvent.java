package com.neu.eventsourcing.command.adapter.handler.event;

import java.time.LocalDateTime;
import java.util.Map;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ScanCompletedEvent {

  @TargetAggregateIdentifier
  private final String scanId;
  private final LocalDateTime completedAt;

  public ScanCompletedEvent(String scanId) {
    this.scanId = scanId;
    this.completedAt = LocalDateTime.now();
  }

  public String getScanId() {
    return scanId;
  }

  public LocalDateTime getCompletedAt() {
    return completedAt;
  }
}

