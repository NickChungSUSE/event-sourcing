package com.neu.eventsourcing.scanner.event;


import java.time.LocalDateTime;

public class ScanCompletedEvent {

  private String scanId;
  private LocalDateTime completedAt;

  public ScanCompletedEvent() {
  }

  public ScanCompletedEvent(String scanId) {
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

