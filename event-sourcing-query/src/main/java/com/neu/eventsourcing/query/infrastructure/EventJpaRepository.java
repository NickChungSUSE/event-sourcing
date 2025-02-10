package com.neu.eventsourcing.query.infrastructure;

import java.util.Set;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<DomainEventEntry, Long> {

  Set<DomainEventEntry> findByAggregateIdentifier(String aggregateIdentifier);
}
