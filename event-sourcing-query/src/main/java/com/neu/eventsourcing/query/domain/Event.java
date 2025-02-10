package com.neu.eventsourcing.query.domain;

import java.time.Instant;

public class Event {

  private final String eventIdentifier;
  private final Payload payload;
  private final MetaData metaData;
  private final String type;
  private final String aggregateIdentifier;
  private final long sequenceNumber;
  private final Instant timestamp;

  // Private constructor
  private Event(Builder builder) {
    this.eventIdentifier = builder.eventIdentifier;
    this.payload = builder.payload;
    this.metaData = builder.metaData;
    this.type = builder.type;
    this.aggregateIdentifier = builder.aggregateIdentifier;
    this.sequenceNumber = builder.sequenceNumber;
    this.timestamp = builder.timestamp;
  }

  // Getters
  public String getEventIdentifier() {
    return eventIdentifier;
  }

  public Payload getPayload() {
    return payload;
  }

  public MetaData getMetaData() {
    return metaData;
  }

  public String getType() {
    return type;
  }

  public String getAggregateIdentifier() {
    return aggregateIdentifier;
  }

  public long getSequenceNumber() {
    return sequenceNumber;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "EventData{" + "eventIdentifier='" + eventIdentifier + '\'' + ", payload=" + payload
        + ", metaData=" + metaData + ", type='" + type + '\'' + ", aggregateIdentifier='"
        + aggregateIdentifier + '\'' + ", sequenceNumber=" + sequenceNumber + ", timestamp='"
        + timestamp + '\'' + '}';
  }

  // Builder Class
  public static class Builder {

    private String eventIdentifier;
    private Payload payload;
    private MetaData metaData;
    private String type;
    private String aggregateIdentifier;
    private long sequenceNumber;
    private Instant timestamp;

    public Builder eventIdentifier(String eventIdentifier) {
      this.eventIdentifier = eventIdentifier;
      return this;
    }

    public Builder payload(Payload payload) {
      this.payload = payload;
      return this;
    }

    public Builder metaData(MetaData metaData) {
      this.metaData = metaData;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder aggregateIdentifier(String aggregateIdentifier) {
      this.aggregateIdentifier = aggregateIdentifier;
      return this;
    }

    public Builder sequenceNumber(long sequenceNumber) {
      this.sequenceNumber = sequenceNumber;
      return this;
    }

    public Builder timestamp(Instant timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Event build() {
      return new Event(this);
    }
  }
}
