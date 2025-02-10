package com.neu.eventsourcing.scanner.event;

import java.time.LocalDateTime;

public class ScanProgressEvent {

  private String scanId;
  private LocalDateTime timestamp;

  // Required for JSON deserialization
  public ScanProgressEvent() {
  }

  public ScanProgressEvent(String scanId) {
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

