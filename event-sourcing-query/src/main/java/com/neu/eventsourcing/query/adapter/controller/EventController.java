package com.neu.eventsourcing.query.adapter.controller;

import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.usecase.EventService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/events")
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping
  public ResponseEntity<Set<Event>> query() {
    return ResponseEntity.ok(eventService.query());
  }

  @GetMapping(path = "/{aggregateId}")
  public ResponseEntity<Set<Event>> queryByAggregateId(
      @PathVariable String aggregateId) {
    return ResponseEntity.ok(eventService.getByAggregateId(aggregateId));
  }
}
