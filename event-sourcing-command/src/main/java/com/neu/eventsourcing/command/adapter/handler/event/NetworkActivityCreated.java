package com.neu.eventsourcing.command.adapter.handler.event;

import java.time.Instant;
import java.util.Set;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class NetworkActivityCreated {

  @TargetAggregateIdentifier
  private String id;
  private Long bytes;
  private Set<String> applications;
  private Set<String> eventType;
  private Set<String> protocols;
  private String fromDomain;
  private String fromGroup;
  private String label;
  private String source;
  private String status;
  private String target;
  private String toDomain;
  private String toGroup;
  private final Long timestamp;

  public NetworkActivityCreated() {
    this.timestamp = Instant.now().getEpochSecond() * 1000;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getBytes() {
    return bytes;
  }

  public void setBytes(Long bytes) {
    this.bytes = bytes;
  }

  public Set<String> getApplications() {
    return applications;
  }

  public void setApplications(Set<String> applications) {
    this.applications = applications;
  }

  public Set<String> getEventType() {
    return eventType;
  }

  public void setEventType(Set<String> eventType) {
    this.eventType = eventType;
  }

  public Set<String> getProtocols() {
    return protocols;
  }

  public void setProtocols(Set<String> protocols) {
    this.protocols = protocols;
  }

  public String getFromDomain() {
    return fromDomain;
  }

  public void setFromDomain(String fromDomain) {
    this.fromDomain = fromDomain;
  }

  public String getFromGroup() {
    return fromGroup;
  }

  public void setFromGroup(String fromGroup) {
    this.fromGroup = fromGroup;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getToDomain() {
    return toDomain;
  }

  public void setToDomain(String toDomain) {
    this.toDomain = toDomain;
  }

  public String getToGroup() {
    return toGroup;
  }

  public void setToGroup(String toGroup) {
    this.toGroup = toGroup;
  }

  public Long getTimestamp() {
    return timestamp;
  }
}
