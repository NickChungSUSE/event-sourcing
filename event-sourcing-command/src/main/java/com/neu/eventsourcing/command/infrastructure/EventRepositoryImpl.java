package com.neu.eventsourcing.command.infrastructure;

import com.neu.eventsourcing.command.domain.Event;
import com.neu.eventsourcing.command.domain.EventRepository;
import com.neu.eventsourcing.command.infrastructure.entity.EventJpaData;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {

  private final EventJpaRepository eventJpaRepository;

  public EventRepositoryImpl(EventJpaRepository eventJpaRepository) {
    this.eventJpaRepository = eventJpaRepository;
  }

  @Override
  public Event getById(Long id) {
    return map(eventJpaRepository.getReferenceById(id));
  }

  @Override
  public Long create(Event event) {
    return eventJpaRepository.save(map(event)).getId();
  }

  private EventJpaData map(Event event) {
    return new EventJpaData(event.getCorrelationId());
  }

  private Event map(EventJpaData data) {
    return new Event(data.getId(), data.getCorrelationId());
  }

}
