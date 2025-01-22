package com.neu.eventsourcing.command.infrastructure;

import com.neu.eventsourcing.command.infrastructure.entity.EventJpaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventJpaData, Long> {

}
