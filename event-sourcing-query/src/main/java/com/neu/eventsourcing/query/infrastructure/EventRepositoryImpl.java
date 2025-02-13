package com.neu.eventsourcing.query.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.domain.EventRepository;
import com.neu.eventsourcing.query.domain.MetaData;
import com.neu.eventsourcing.query.domain.Payload;
import java.util.Set;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EventRepositoryImpl implements EventRepository {

  private final ObjectMapper objectMapper;

  private final EventJpaRepository eventJpaRepository;

  public EventRepositoryImpl(EventJpaRepository eventJpaRepository, ObjectMapper objectMapper) {
    this.eventJpaRepository = eventJpaRepository;
    this.objectMapper = objectMapper;
  }


  @Override
  @Transactional(readOnly = true)
  public Set<Event> query() {
    return eventJpaRepository.findAll().stream().map(this::map).collect(Collectors.toSet());
  }

  @Override
  @Transactional(readOnly = true)
  public Set<Event> getByAggregateId(String aggregateId) {
    return eventJpaRepository.findByAggregateIdentifier(aggregateId).stream().map(this::map)
        .collect(Collectors.toSet());
  }

  private Event map(DomainEventEntry entry) {
    MetaData metaData = new MetaData.Builder().data(new String(entry.getMetaData().getData()))
        .type(entry.getMetaData().getType())
        .contentType(getReadableContentType(entry.getMetaData().getContentType())).build();
    Payload payload = new Payload.Builder().data(new String(entry.getPayload().getData()))
        .type(entry.getPayload().getType())
        .contentType(getReadableContentType(entry.getPayload().getContentType())).build();
    return new Event.Builder().eventIdentifier(entry.getEventIdentifier())
        .aggregateIdentifier(entry.getAggregateIdentifier()).metaData(metaData).payload(payload)
        .sequenceNumber(entry.getSequenceNumber()).timestamp(entry.getTimestamp())
        .type(entry.getType()).build();
  }

  private String getReadableContentType(Class<?> contentTypeClass) {
    if (contentTypeClass == byte[].class) {
      return "byte[]";
    }
    return contentTypeClass.toString();
  }
}
