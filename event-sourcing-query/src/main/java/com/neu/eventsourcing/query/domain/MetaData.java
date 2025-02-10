package com.neu.eventsourcing.query.domain;

public class MetaData {

  private final String data;
  private final String contentType;
  private final Object type;

  private MetaData(Builder builder) {
    this.data = builder.data;
    this.contentType = builder.contentType;
    this.type = builder.type;
  }

  public String getData() {
    return data;
  }

  public String getContentType() {
    return contentType;
  }

  public Object getType() {
    return type;
  }

  @Override
  public String toString() {
    return "MetaData{" + "data='" + data + '\'' + ", type=" + type + ", contentType='" + contentType
        + '\'' + '}';
  }

  public static class Builder {

    private String data;
    private Object type;
    private String contentType;

    public Builder data(String data) {
      this.data = data;
      return this;
    }

    public Builder type(Object type) {
      this.type = type;
      return this;
    }

    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    public MetaData build() {
      return new MetaData(this);
    }
  }
}
