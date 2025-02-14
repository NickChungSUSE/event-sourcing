package com.neu.eventsourcing.command.adapter.controller.request;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;

public class CreateNetworkActivityRequest {

  private Set<Edge> edges;
  private Set<Node> nodes;
  private Set<Combo> combos;

  public CreateNetworkActivityRequest() {
  }

  public Set<Edge> getEdges() {
    return edges;
  }

  public void setEdges(Set<Edge> edges) {
    this.edges = edges;
  }

  public Set<Node> getNodes() {
    return nodes;
  }

  public void setNodes(Set<Node> nodes) {
    this.nodes = nodes;
  }

  public Set<Combo> getCombos() {
    return combos;
  }

  public void setCombos(Set<Combo> combos) {
    this.combos = combos;
  }

  public static class Edge {

    private String id;
    private Long bytes;
    private Set<String> applications;
    private Set<String> event_type;
    private Set<String> protocols;
    private String fromDomain;
    private String fromGroup;
    private String label;
    private String source;
    private String status;
    private String target;
    private String toDomain;
    private String toGroup;

    public Edge() {
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public Long getBytes() {
      return bytes;
    }

    public void setBytes(Long bytes) {
      this.bytes = bytes;
    }

    public Set<String> getApplications() {
      return applications;
    }

    public void setApplications(Set<String> applications) {
      this.applications = applications;
    }

    public Set<String> getEventType() {
      return event_type;
    }

    public void setEventType(Set<String> eventType) {
      this.event_type = eventType;
    }

    public Set<String> getProtocols() {
      return protocols;
    }

    public void setProtocols(Set<String> protocols) {
      this.protocols = protocols;
    }

    public String getFromDomain() {
      return fromDomain;
    }

    public void setFromDomain(String fromDomain) {
      this.fromDomain = fromDomain;
    }

    public String getFromGroup() {
      return fromGroup;
    }

    public void setFromGroup(String fromGroup) {
      this.fromGroup = fromGroup;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getSource() {
      return source;
    }

    public void setSource(String source) {
      this.source = source;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public String getTarget() {
      return target;
    }

    public void setTarget(String target) {
      this.target = target;
    }

    public String getToDomain() {
      return toDomain;
    }

    public void setToDomain(String toDomain) {
      this.toDomain = toDomain;
    }

    public String getToGroup() {
      return toGroup;
    }

    public void setToGroup(String toGroup) {
      this.toGroup = toGroup;
    }
  }

  public static class Node {

    private String id;
    private boolean cap_change_mode;
    private boolean cap_quarantine;
    private boolean cap_sniff;
    private Set<Children> children;
    private String clusterId;
    private String clusterName;
    private String domain;
    private String group;
    private String label;
    private String platform_role;
    private String policyMode;
    private ScanBrief scanBrief;
    private boolean service_mesh;
    private boolean service_mesh_sidecar;
    private String state;
    private Long timestamp;
    private NodeData data;
    private Style style;
    private String combo;

    public Node() {
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public boolean isCap_change_mode() {
      return cap_change_mode;
    }

    public void setCap_change_mode(boolean cap_change_mode) {
      this.cap_change_mode = cap_change_mode;
    }

    public boolean isCap_quarantine() {
      return cap_quarantine;
    }

    public void setCap_quarantine(boolean cap_quarantine) {
      this.cap_quarantine = cap_quarantine;
    }

    public boolean isCap_sniff() {
      return cap_sniff;
    }

    public void setCap_sniff(boolean cap_sniff) {
      this.cap_sniff = cap_sniff;
    }

    public Set<Children> getChildren() {
      return children;
    }

    public void setChildren(Set<Children> children) {
      this.children = children;
    }

    public String getClusterId() {
      return clusterId;
    }

    public void setClusterId(String clusterId) {
      this.clusterId = clusterId;
    }

    public String getClusterName() {
      return clusterName;
    }

    public void setClusterName(String clusterName) {
      this.clusterName = clusterName;
    }

    public String getDomain() {
      return domain;
    }

    public void setDomain(String domain) {
      this.domain = domain;
    }

    public String getGroup() {
      return group;
    }

    public void setGroup(String group) {
      this.group = group;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getPlatform_role() {
      return platform_role;
    }

    public void setPlatform_role(String platform_role) {
      this.platform_role = platform_role;
    }

    public String getPolicyMode() {
      return policyMode;
    }

    public void setPolicyMode(String policyMode) {
      this.policyMode = policyMode;
    }

    public ScanBrief getScanBrief() {
      return scanBrief;
    }

    public void setScanBrief(ScanBrief scanBrief) {
      this.scanBrief = scanBrief;
    }

    public boolean isService_mesh() {
      return service_mesh;
    }

    public void setService_mesh(boolean service_mesh) {
      this.service_mesh = service_mesh;
    }

    public boolean isService_mesh_sidecar() {
      return service_mesh_sidecar;
    }

    public void setService_mesh_sidecar(boolean service_mesh_sidecar) {
      this.service_mesh_sidecar = service_mesh_sidecar;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public Long getTimestamp() {
      return timestamp;
    }

    public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
    }

    public NodeData getData() {
      return data;
    }

    public void setData(NodeData data) {
      this.data = data;
    }

    public Style getStyle() {
      return style;
    }

    public void setStyle(Style style) {
      this.style = style;
    }

    public String getCombo() {
      return combo;
    }

    public void setCombo(String combo) {
      this.combo = combo;
    }
  }

  public static class Children {

    private String label;
    private ScanBrief scanBrief;
    private boolean sidecar;

    public Children() {

    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public ScanBrief getScanBrief() {
      return scanBrief;
    }

    public void setScanBrief(ScanBrief scanBrief) {
      this.scanBrief = scanBrief;
    }

    public boolean isSidecar() {
      return sidecar;
    }

    public void setSidecar(boolean sidecar) {
      this.sidecar = sidecar;
    }
  }

  public static class ScanBrief {

    private int high;
    private int medium;
    private String status;

    public ScanBrief() {

    }

    public int getHigh() {
      return high;
    }

    public void setHigh(int high) {
      this.high = high;
    }

    public int getMedium() {
      return medium;
    }

    public void setMedium(int medium) {
      this.medium = medium;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
  }

  public static class NodeData {

    private Instant time;
    private long value;
    private String label;

    public NodeData() {

    }

    public Instant getTime() {
      return time;
    }

    public void setTime(Instant time) {
      this.time = time;
    }

    public long getValue() {
      return value;
    }

    public void setValue(long value) {
      this.value = value;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }
  }

  public static class Style {

    private String labelText;

    public Style() {
    }


    public String getLabelText() {
      return labelText;
    }

    public void setLabelText(String labelText) {
      this.labelText = labelText;
    }
  }

  public static class Combo {

    private String id;
    private Style style;

    public Combo() {
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public Style getStyle() {
      return style;
    }

    public void setStyle(Style style) {
      this.style = style;
    }
  }
}
