package com.neu.eventsourcing.command.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EventJpaData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long correlationId;

  protected EventJpaData() {
  }

  public EventJpaData(Long correlationId) {
    this.correlationId = correlationId;
  }

  public Long getId() {
    return id;
  }

  public Long getCorrelationId() {
    return correlationId;
  }

  @Override
  public String toString() {
    return "EventJpaData{" + "id=" + id + ", correlationId=" + correlationId + '}';
  }
}
