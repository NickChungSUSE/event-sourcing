package com.neu.eventsourcing.command.domain;

import java.util.UUID;

public class Event {

  private Long id;
  private Long correlationId;

  public Event() {

  }

  public Event(Long correlationId) {
    this.correlationId = correlationId;
  }

  public Event(Long id, Long correlationId) {
    this.id = id;
    this.correlationId = correlationId;
  }

  public Long getId() {
    return id;
  }

  public Long getCorrelationId() {
    return correlationId;
  }

  public void generateCorrelationId() {
    this.correlationId = UUID.randomUUID().getMostSignificantBits();
  }

  @Override
  public String toString() {
    return "Event{" + "id=" + id + ", correlationId=" + correlationId + '}';
  }
}
