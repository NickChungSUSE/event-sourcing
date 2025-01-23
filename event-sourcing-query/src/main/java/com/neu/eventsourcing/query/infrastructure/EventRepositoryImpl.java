package com.neu.eventsourcing.query.infrastructure;

import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.domain.EventRepository;
import com.neu.eventsourcing.query.infrastructure.entity.EventJpaData;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {

  private final EventJpaRepository eventJpaRepository;

  public EventRepositoryImpl(EventJpaRepository eventJpaRepository) {
    this.eventJpaRepository = eventJpaRepository;
  }

  @Override
  public Set<Event> query() {
    return eventJpaRepository.findAll().stream().map(this::map).collect(Collectors.toSet());
  }

  @Override
  public Event getById(Long id) {
    return map(eventJpaRepository.getReferenceById(id));
  }
  
  private Event map(EventJpaData data) {
    return new Event(data.getId(), data.getCorrelationId());
  }

}
