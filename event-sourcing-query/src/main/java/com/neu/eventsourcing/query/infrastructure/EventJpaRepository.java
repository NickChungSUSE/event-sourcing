package com.neu.eventsourcing.query.infrastructure;

import com.neu.eventsourcing.query.infrastructure.entity.EventJpaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventJpaData, Long> {

}
