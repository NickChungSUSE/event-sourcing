package com.neu.eventsourcing.query.domain;

import java.util.Set;

public interface EventRepository {

  Set<Event> query();

  Set<Event> getByAggregateId(String aggregateId);
}
