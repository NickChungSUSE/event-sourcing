package com.neu.eventsourcing.command.infrastructure;

public interface EventGateway {

  void publish(String topic, String key, Object event);
}
