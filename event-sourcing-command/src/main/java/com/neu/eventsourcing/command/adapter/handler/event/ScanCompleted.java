package com.neu.eventsourcing.command.adapter.handler.event;

import java.time.LocalDateTime;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ScanCompleted {

  @TargetAggregateIdentifier
  private String scanId;
  private LocalDateTime completedAt;

  public ScanCompleted() {
  }

  public ScanCompleted(String scanId) {
    this.scanId = scanId;
    this.completedAt = LocalDateTime.now();
  }

  public String getScanId() {
    return scanId;
  }

  public void setScanId(String scanId) {
    this.scanId = scanId;
  }

  public LocalDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(LocalDateTime completedAt) {
    this.completedAt = completedAt;
  }
}

