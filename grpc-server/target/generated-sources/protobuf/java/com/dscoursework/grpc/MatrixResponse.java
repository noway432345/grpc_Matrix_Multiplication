// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MultService.proto

package com.dscoursework.grpc;

/**
 * Protobuf type {@code com.dscoursework.grpc.MatrixResponse}
 */
public  final class MatrixResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.dscoursework.grpc.MatrixResponse)
    MatrixResponseOrBuilder {
  // Use MatrixResponse.newBuilder() to construct.
  private MatrixResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MatrixResponse() {
    matrix_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MatrixResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            matrix_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dscoursework.grpc.MultService.internal_static_com_dscoursework_grpc_MatrixResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dscoursework.grpc.MultService.internal_static_com_dscoursework_grpc_MatrixResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dscoursework.grpc.MatrixResponse.class, com.dscoursework.grpc.MatrixResponse.Builder.class);
  }

  public static final int MATRIX_FIELD_NUMBER = 1;
  private volatile java.lang.Object matrix_;
  /**
   * <code>string Matrix = 1;</code>
   */
  public java.lang.String getMatrix() {
    java.lang.Object ref = matrix_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      matrix_ = s;
      return s;
    }
  }
  /**
   * <code>string Matrix = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMatrixBytes() {
    java.lang.Object ref = matrix_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      matrix_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getMatrixBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, matrix_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMatrixBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, matrix_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.dscoursework.grpc.MatrixResponse)) {
      return super.equals(obj);
    }
    com.dscoursework.grpc.MatrixResponse other = (com.dscoursework.grpc.MatrixResponse) obj;

    boolean result = true;
    result = result && getMatrix()
        .equals(other.getMatrix());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MATRIX_FIELD_NUMBER;
    hash = (53 * hash) + getMatrix().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dscoursework.grpc.MatrixResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dscoursework.grpc.MatrixResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dscoursework.grpc.MatrixResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.dscoursework.grpc.MatrixResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.dscoursework.grpc.MatrixResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.dscoursework.grpc.MatrixResponse)
      com.dscoursework.grpc.MatrixResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dscoursework.grpc.MultService.internal_static_com_dscoursework_grpc_MatrixResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dscoursework.grpc.MultService.internal_static_com_dscoursework_grpc_MatrixResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dscoursework.grpc.MatrixResponse.class, com.dscoursework.grpc.MatrixResponse.Builder.class);
    }

    // Construct using com.dscoursework.grpc.MatrixResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      matrix_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dscoursework.grpc.MultService.internal_static_com_dscoursework_grpc_MatrixResponse_descriptor;
    }

    public com.dscoursework.grpc.MatrixResponse getDefaultInstanceForType() {
      return com.dscoursework.grpc.MatrixResponse.getDefaultInstance();
    }

    public com.dscoursework.grpc.MatrixResponse build() {
      com.dscoursework.grpc.MatrixResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dscoursework.grpc.MatrixResponse buildPartial() {
      com.dscoursework.grpc.MatrixResponse result = new com.dscoursework.grpc.MatrixResponse(this);
      result.matrix_ = matrix_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.dscoursework.grpc.MatrixResponse) {
        return mergeFrom((com.dscoursework.grpc.MatrixResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dscoursework.grpc.MatrixResponse other) {
      if (other == com.dscoursework.grpc.MatrixResponse.getDefaultInstance()) return this;
      if (!other.getMatrix().isEmpty()) {
        matrix_ = other.matrix_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.dscoursework.grpc.MatrixResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dscoursework.grpc.MatrixResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object matrix_ = "";
    /**
     * <code>string Matrix = 1;</code>
     */
    public java.lang.String getMatrix() {
      java.lang.Object ref = matrix_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        matrix_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Matrix = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMatrixBytes() {
      java.lang.Object ref = matrix_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        matrix_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Matrix = 1;</code>
     */
    public Builder setMatrix(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      matrix_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Matrix = 1;</code>
     */
    public Builder clearMatrix() {
      
      matrix_ = getDefaultInstance().getMatrix();
      onChanged();
      return this;
    }
    /**
     * <code>string Matrix = 1;</code>
     */
    public Builder setMatrixBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      matrix_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.dscoursework.grpc.MatrixResponse)
  }

  // @@protoc_insertion_point(class_scope:com.dscoursework.grpc.MatrixResponse)
  private static final com.dscoursework.grpc.MatrixResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dscoursework.grpc.MatrixResponse();
  }

  public static com.dscoursework.grpc.MatrixResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MatrixResponse>
      PARSER = new com.google.protobuf.AbstractParser<MatrixResponse>() {
    public MatrixResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MatrixResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MatrixResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MatrixResponse> getParserForType() {
    return PARSER;
  }

  public com.dscoursework.grpc.MatrixResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

