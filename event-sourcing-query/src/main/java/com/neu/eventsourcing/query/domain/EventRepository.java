package com.neu.eventsourcing.query.domain;

import java.util.Set;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;

public interface EventRepository {

  Set<Event> query();

  Set<Event> getByAggregateId(String aggregateId);
}
