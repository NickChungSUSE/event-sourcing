package com.neu.eventsourcing.scanner.event;

import java.time.LocalDateTime;

public class ScanFailedEvent {

  private final String scanId;
  private final String errorMessage;
  private final LocalDateTime timestamp;

  public ScanFailedEvent(String scanId, String errorMessage, LocalDateTime timestamp) {
    this.scanId = scanId;
    this.errorMessage = errorMessage;
    this.timestamp = timestamp;
  }

  public String getScanId() {
    return scanId;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
