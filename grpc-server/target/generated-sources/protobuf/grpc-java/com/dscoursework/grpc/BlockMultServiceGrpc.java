package com.dscoursework.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: MultService.proto")
public final class BlockMultServiceGrpc {

  private BlockMultServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dscoursework.grpc.BlockMultService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dscoursework.grpc.MatrixRequest,
      com.dscoursework.grpc.MatrixResponse> METHOD_ADD_BLOCK =
      io.grpc.MethodDescriptor.<com.dscoursework.grpc.MatrixRequest, com.dscoursework.grpc.MatrixResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dscoursework.grpc.BlockMultService", "AddBlock"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dscoursework.grpc.MatrixRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dscoursework.grpc.MatrixResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dscoursework.grpc.MatrixRequest,
      com.dscoursework.grpc.MatrixResponse> METHOD_MULTIPLY_BLOCK =
      io.grpc.MethodDescriptor.<com.dscoursework.grpc.MatrixRequest, com.dscoursework.grpc.MatrixResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dscoursework.grpc.BlockMultService", "MultiplyBlock"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dscoursework.grpc.MatrixRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dscoursework.grpc.MatrixResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlockMultServiceStub newStub(io.grpc.Channel channel) {
    return new BlockMultServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlockMultServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BlockMultServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlockMultServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BlockMultServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BlockMultServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addBlock(com.dscoursework.grpc.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.dscoursework.grpc.MatrixResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_BLOCK, responseObserver);
    }

    /**
     */
    public void multiplyBlock(com.dscoursework.grpc.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.dscoursework.grpc.MatrixResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MULTIPLY_BLOCK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_BLOCK,
            asyncUnaryCall(
              new MethodHandlers<
                com.dscoursework.grpc.MatrixRequest,
                com.dscoursework.grpc.MatrixResponse>(
                  this, METHODID_ADD_BLOCK)))
          .addMethod(
            METHOD_MULTIPLY_BLOCK,
            asyncUnaryCall(
              new MethodHandlers<
                com.dscoursework.grpc.MatrixRequest,
                com.dscoursework.grpc.MatrixResponse>(
                  this, METHODID_MULTIPLY_BLOCK)))
          .build();
    }
  }

  /**
   */
  public static final class BlockMultServiceStub extends io.grpc.stub.AbstractStub<BlockMultServiceStub> {
    private BlockMultServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlockMultServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockMultServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlockMultServiceStub(channel, callOptions);
    }

    /**
     */
    public void addBlock(com.dscoursework.grpc.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.dscoursework.grpc.MatrixResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_BLOCK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void multiplyBlock(com.dscoursework.grpc.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.dscoursework.grpc.MatrixResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MULTIPLY_BLOCK, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BlockMultServiceBlockingStub extends io.grpc.stub.AbstractStub<BlockMultServiceBlockingStub> {
    private BlockMultServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlockMultServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockMultServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlockMultServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dscoursework.grpc.MatrixResponse addBlock(com.dscoursework.grpc.MatrixRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_BLOCK, getCallOptions(), request);
    }

    /**
     */
    public com.dscoursework.grpc.MatrixResponse multiplyBlock(com.dscoursework.grpc.MatrixRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MULTIPLY_BLOCK, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BlockMultServiceFutureStub extends io.grpc.stub.AbstractStub<BlockMultServiceFutureStub> {
    private BlockMultServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlockMultServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockMultServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlockMultServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dscoursework.grpc.MatrixResponse> addBlock(
        com.dscoursework.grpc.MatrixRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_BLOCK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dscoursework.grpc.MatrixResponse> multiplyBlock(
        com.dscoursework.grpc.MatrixRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MULTIPLY_BLOCK, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_BLOCK = 0;
  private static final int METHODID_MULTIPLY_BLOCK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlockMultServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlockMultServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_BLOCK:
          serviceImpl.addBlock((com.dscoursework.grpc.MatrixRequest) request,
              (io.grpc.stub.StreamObserver<com.dscoursework.grpc.MatrixResponse>) responseObserver);
          break;
        case METHODID_MULTIPLY_BLOCK:
          serviceImpl.multiplyBlock((com.dscoursework.grpc.MatrixRequest) request,
              (io.grpc.stub.StreamObserver<com.dscoursework.grpc.MatrixResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BlockMultServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dscoursework.grpc.MultService.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlockMultServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlockMultServiceDescriptorSupplier())
              .addMethod(METHOD_ADD_BLOCK)
              .addMethod(METHOD_MULTIPLY_BLOCK)
              .build();
        }
      }
    }
    return result;
  }
}
