package com.neu.eventsourcing.mockservice.event;


import java.time.LocalDateTime;

public class ScanCompleted {

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

