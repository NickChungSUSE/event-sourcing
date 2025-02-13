package com.neu.eventsourcing.command.usecase;

import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventhandling.GenericDomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EventService {

  private static final Logger logger = LoggerFactory.getLogger(EventService.class);

  @Autowired
  private EventStore eventStore;

  public void storeEvent(String type, Object event, String aggregateId) {
    try {
      DomainEventMessage<?> domainEvent = new GenericDomainEventMessage<>(type, aggregateId,
          getNextSequenceNumber(aggregateId), event);

      eventStore.publish(domainEvent);
      logger.info("Event stored successfully for Aggregate ID: {}", aggregateId);
    } catch (Exception e) {
      logger.error("Failed to store event in Event Store for Aggregate ID: {}", aggregateId, e);
    }
  }

  private long getNextSequenceNumber(String aggregateId) {
    try {
      return eventStore.readEvents(aggregateId).asStream().count();
    } catch (AggregateNotFoundException e) {
      return 0L;
    }
  }
}
