package com.neu.eventsourcing.mockservice.event;

import java.time.LocalDateTime;

public class ScanFailed {

  private final String scanId;
  private final String errorMessage;
  private final LocalDateTime timestamp;

  public ScanFailed(String scanId, String errorMessage, LocalDateTime timestamp) {
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
