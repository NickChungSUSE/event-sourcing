package com.neu.eventsourcing.query.domain;

public class Payload {

  private final String data;
  private final Object type;
  private final String contentType;

  private Payload(Builder builder) {
    this.data = builder.data;
    this.type = builder.type;
    this.contentType = builder.contentType;
  }

  public String getData() {
    return data;
  }

  public Object getType() {
    return type;
  }

  public String getContentType() {
    return contentType;
  }

  @Override
  public String toString() {
    return "Payload{" + "data='" + data + '\'' + ", type=" + type + ", contentType='" + contentType
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

    public Payload build() {
      return new Payload(this);
    }
  }
}

