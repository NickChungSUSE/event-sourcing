package com.neu.eventsourcing.command.usecase;

import com.neu.eventsourcing.command.adapter.controller.request.CreateNetworkActivityRequest;
import com.neu.eventsourcing.command.adapter.controller.request.CreateNetworkActivityRequest.Children;
import com.neu.eventsourcing.command.adapter.controller.request.CreateNetworkActivityRequest.NodeData;
import com.neu.eventsourcing.command.adapter.controller.request.CreateNetworkActivityRequest.ScanBrief;
import com.neu.eventsourcing.command.adapter.controller.request.CreateNetworkActivityRequest.Style;
import com.neu.eventsourcing.command.adapter.handler.event.NetworkActivityCreated;
import com.neu.eventsourcing.command.infrastructure.EventGateway;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
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

  public void createNetworkActivities(CreateNetworkActivityRequest request) {
    NetworkActivityCreated event = map(request);
    eventGateway.publish(NETWORK_ACTIVITY_EVENT_TOPIC, event.getId(), event);
  }

  private NetworkActivityCreated map(CreateNetworkActivityRequest request) {
    NetworkActivityCreated event = new NetworkActivityCreated();
    event.setId(UUID.randomUUID().toString());
    event.setEdges(request.getEdges().stream().map(this::map).collect(Collectors.toSet()));
    event.setNodes(request.getNodes().stream().map(this::map).collect(Collectors.toSet()));
    event.setCombos(request.getCombos().stream().map(this::map).collect(Collectors.toSet()));
    return event;
  }

  private NetworkActivityCreated.Edge map(CreateNetworkActivityRequest.Edge data) {
    NetworkActivityCreated.Edge edge = new NetworkActivityCreated.Edge();
    edge.setId(data.getId());
    edge.setEventType(data.getEventType());
    edge.setApplications(data.getApplications());
    edge.setBytes(data.getBytes());
    edge.setLabel(data.getLabel());
    edge.setFromDomain(data.getFromDomain());
    edge.setFromGroup(data.getFromGroup());
    edge.setSource(data.getSource());
    edge.setStatus(data.getStatus());
    edge.setTarget(data.getTarget());
    edge.setToDomain(data.getToDomain());
    edge.setToGroup(data.getToGroup());
    return edge;
  }

  private NetworkActivityCreated.Node map(CreateNetworkActivityRequest.Node data) {
    NetworkActivityCreated.Node node = new NetworkActivityCreated.Node();
    node.setId(data.getId());
    node.setCap_change_mode(data.isCap_change_mode());
    node.setCap_quarantine(data.isCap_quarantine());
    node.setCap_sniff(data.isCap_sniff());
    node.setClusterId(data.getClusterId());
    node.setClusterName(data.getClusterName());
    node.setDomain(data.getDomain());
    node.setGroup(data.getGroup());
    node.setLabel(data.getLabel());
    node.setPlatform_role(data.getPlatform_role());
    node.setPolicyMode(data.getPolicyMode());
    node.setService_mesh(data.isService_mesh());
    node.setService_mesh_sidecar(data.isService_mesh_sidecar());
    node.setState(data.getState());
    node.setTimestamp(data.getTimestamp());
    node.setCombo(data.getCombo());
    node.setStyle(map(data.getStyle()));
    node.setData(map(data.getData()));
    if (data != null && data.getScanBrief() != null) {
      node.setScanBrief(map(data.getScanBrief()));
    }

    if (data != null && data.getChildren() != null) {
      Set<NetworkActivityCreated.Children> children = data.getChildren().stream().map(this::map)
          .collect(Collectors.toSet());
      node.setChildren(children);
    }
    return node;
  }

  private NetworkActivityCreated.Style map(CreateNetworkActivityRequest.Style data) {
    NetworkActivityCreated.Style style = new NetworkActivityCreated.Style();
    style.setLabelText(data.getLabelText());
    return style;
  }

  private NetworkActivityCreated.NodeData map(CreateNetworkActivityRequest.NodeData data) {
    NetworkActivityCreated.NodeData nodeData = new NetworkActivityCreated.NodeData();
    nodeData.setTime(data.getTime().getEpochSecond() * 1000);
    nodeData.setValue(data.getValue());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a")
        .withZone(ZoneId.systemDefault());
    nodeData.setLabel(ZonedDateTime.parse(data.getLabel(), formatter).toEpochSecond() * 1000);
    return nodeData;
  }

  private NetworkActivityCreated.ScanBrief map(CreateNetworkActivityRequest.ScanBrief data) {
    NetworkActivityCreated.ScanBrief scanBrief = new NetworkActivityCreated.ScanBrief();
    scanBrief.setHigh(data.getHigh());
    scanBrief.setMedium(data.getMedium());
    scanBrief.setStatus(data.getStatus());
    return scanBrief;
  }

  private NetworkActivityCreated.Children map(CreateNetworkActivityRequest.Children data) {
    NetworkActivityCreated.Children children = new NetworkActivityCreated.Children();
    children.setLabel(data.getLabel());
    children.setSidecar(data.isSidecar());
    children.setScanBrief(map(data.getScanBrief()));
    return children;
  }

  private NetworkActivityCreated.Combo map(CreateNetworkActivityRequest.Combo data) {
    NetworkActivityCreated.Combo combo = new NetworkActivityCreated.Combo();
    combo.setId(data.getId());
    combo.setStyle(map(data.getStyle()));
    return combo;
  }
}
