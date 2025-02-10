package com.neu.eventsourcing.query.usecase;

import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.domain.EventRepository;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  public Set<Event> query() {
    return eventRepository.query();
  }

  public Set<Event> getByAggregateId(String id) {
    return eventRepository.getByAggregateId(id);
  }
}
