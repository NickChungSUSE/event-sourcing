package com.neu.eventsourcing.query.usecase;

import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.domain.EventRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  private final EventRepository eventRepository;

  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public Set<Event> query() {
    return eventRepository.query();
  }

  public Set<Event> getByAggregateId(String id) {
    return eventRepository.getByAggregateId(id);
  }
}
