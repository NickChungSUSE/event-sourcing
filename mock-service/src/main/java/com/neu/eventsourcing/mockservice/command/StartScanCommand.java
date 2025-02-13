package com.neu.eventsourcing.mockservice.command;

import java.time.LocalDateTime;

public class StartScanCommand {

  private String scanId;
  private LocalDateTime timestamp;

  public StartScanCommand() {
  }

  public StartScanCommand(String scanId) {
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

