package com.neu.eventsourcing.command.domain;

public interface EventRepository {

  Event getById(Long id);

  Long create(Event event);
}
