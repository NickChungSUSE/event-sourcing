package com.neu.eventsourcing.query.usecase;

import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.domain.EventRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  public Set<Event> query() {
    return eventRepository.query();
  }

  public Event getById(Long id) {
    return eventRepository.getById(id);
  }
}
