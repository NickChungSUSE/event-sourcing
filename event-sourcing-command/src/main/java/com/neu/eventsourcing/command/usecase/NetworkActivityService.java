package com.neu.eventsourcing.command.usecase;

import com.neu.eventsourcing.command.adapter.handler.event.NetworkActivityCreated;
import com.neu.eventsourcing.command.infrastructure.EventGateway;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class NetworkActivityService {

  private static final Logger logger = LoggerFactory.getLogger(NetworkActivityService.class);
  private static final String NETWORK_ACTIVITY_EVENT_TOPIC = "network-activity-events";

  private final EventGateway eventGateway;

  public NetworkActivityService(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  public void createNetworkActivities() {
    NetworkActivityCreated event = createNetworkActivityCreatedEvent();
    eventGateway.publish(NETWORK_ACTIVITY_EVENT_TOPIC, event.getId(), event);
  }

  private NetworkActivityCreated createNetworkActivityCreatedEvent() {
    NetworkActivityCreated event = new NetworkActivityCreated();
    event.setId(UUID.randomUUID().toString());
    event.setEventType(new HashSet<>(List.of("test")));
    event.setApplications(new HashSet<>(List.of("test")));
    event.setBytes(new Random().nextLong());
    event.setLabel("SSL,tcp/9443");
    event.setFromDomain("nvUnmanagedWorkload");
    event.setFromGroup("Workload:ingress");
    event.setSource("Workload:ingress");
    event.setStatus("OK");
    event.setTarget(UUID.randomUUID().toString());
    event.setToDomain("cattle-system");
    event.setToGroup("nv.rancher-webhook.cattle-system");
    return event;
  }
}
