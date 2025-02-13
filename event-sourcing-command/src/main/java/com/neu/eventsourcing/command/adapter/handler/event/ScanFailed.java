package com.neu.eventsourcing.command.adapter.handler.event;

import java.time.LocalDateTime;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ScanFailed {
  @TargetAggregateIdentifier
  private final String scanId;
  private final String errorCode;
  private final String errorMessage;
  private final LocalDateTime failedAt;

  public ScanFailed(String scanId, String errorCode, String errorMessage) {
    this.scanId = scanId;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.failedAt = LocalDateTime.now();
  }

  public String getScanId() {
    return scanId;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public LocalDateTime getFailedAt() {
    return failedAt;
  }
}

