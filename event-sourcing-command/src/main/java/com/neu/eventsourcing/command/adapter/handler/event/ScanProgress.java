package com.neu.eventsourcing.command.adapter.handler.event;

import java.time.LocalDateTime;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ScanProgress {

  @TargetAggregateIdentifier
  private String scanId;
  private LocalDateTime timestamp;

  public ScanProgress() {
  }

  public ScanProgress(String scanId) {
    this.scanId = scanId;
    this.timestamp = LocalDateTime.now();
  }

  public String getScanId() {
    return scanId;
  }

  public void setScanId(String scanId) {
    this.scanId = scanId;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}

