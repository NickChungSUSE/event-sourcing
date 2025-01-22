package com.neu.eventsourcing.command.usecase;

import com.neu.eventsourcing.command.domain.Event;
import com.neu.eventsourcing.command.domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ScanService {

  private static final Logger logger = LoggerFactory.getLogger(ScanService.class);

  @Autowired
  private EventRepository eventRepository;

  public void scan() {
    logger.info("Event Storing....");
    Event event = new Event();
    event.generateCorrelationId();
    Long id = eventRepository.create(event);
    logger.info("Event Created with id: {}", id);
    event = eventRepository.getById(id);
    logger.info(event.toString());
    logger.info("Scan Starting....");
  }
}
