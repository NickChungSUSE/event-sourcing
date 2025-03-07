package com.neu.eventsourcing.query.adapter.controller;

import com.neu.eventsourcing.query.domain.Event;
import com.neu.eventsourcing.query.usecase.EventService;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/events")
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping
  public ResponseEntity<Set<Event>> query() {
    return ResponseEntity.ok(eventService.query());
  }

  @GetMapping(path = "/{aggregateId}")
  public ResponseEntity<Set<Event>> queryByAggregateId(@PathVariable String aggregateId) {
    return ResponseEntity.ok(eventService.getByAggregateId(aggregateId));
  }
}
