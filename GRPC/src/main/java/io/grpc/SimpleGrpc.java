package io.grpc;

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
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: Simple.proto")
public class SimpleGrpc {

  private SimpleGrpc() {}

  public static final String SERVICE_NAME = "Simple";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.MyRequest,
      io.grpc.MyResponse> METHOD_ONE_TO_ONE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "Simple", "OneToOne"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.MyRequest,
      io.grpc.MyResponse> METHOD_ONE_TO_MANY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "Simple", "OneToMany"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.MyRequest,
      io.grpc.MyResponse> METHOD_MANY_TO_ONE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "Simple", "ManyToOne"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.MyRequest,
      io.grpc.MyResponse> METHOD_MANY_TO_MANY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "Simple", "ManyToMany"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.MyResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SimpleStub newStub(io.grpc.Channel channel) {
    return new SimpleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimpleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SimpleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static SimpleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SimpleFutureStub(channel);
  }

  /**
   */
  public static abstract class SimpleImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 简单gRPC
     * </pre>
     */
    public void oneToOne(io.grpc.MyRequest request,
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ONE_TO_ONE, responseObserver);
    }

    /**
     * <pre>
     *服务端流
     * </pre>
     */
    public void oneToMany(io.grpc.MyRequest request,
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ONE_TO_MANY, responseObserver);
    }

    /**
     * <pre>
     *客户端流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.MyRequest> manyToOne(
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_MANY_TO_ONE, responseObserver);
    }

    /**
     * <pre>
     *双向流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.MyRequest> manyToMany(
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_MANY_TO_MANY, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ONE_TO_ONE,
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.MyRequest,
                io.grpc.MyResponse>(
                  this, METHODID_ONE_TO_ONE)))
          .addMethod(
            METHOD_ONE_TO_MANY,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.MyRequest,
                io.grpc.MyResponse>(
                  this, METHODID_ONE_TO_MANY)))
          .addMethod(
            METHOD_MANY_TO_ONE,
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.MyRequest,
                io.grpc.MyResponse>(
                  this, METHODID_MANY_TO_ONE)))
          .addMethod(
            METHOD_MANY_TO_MANY,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.MyRequest,
                io.grpc.MyResponse>(
                  this, METHODID_MANY_TO_MANY)))
          .build();
    }
  }

  /**
   */
  public static final class SimpleStub extends io.grpc.stub.AbstractStub<SimpleStub> {
    private SimpleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单gRPC
     * </pre>
     */
    public void oneToOne(io.grpc.MyRequest request,
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ONE_TO_ONE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *服务端流
     * </pre>
     */
    public void oneToMany(io.grpc.MyRequest request,
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_ONE_TO_MANY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *客户端流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.MyRequest> manyToOne(
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_MANY_TO_ONE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *双向流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.MyRequest> manyToMany(
        io.grpc.stub.StreamObserver<io.grpc.MyResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_MANY_TO_MANY, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SimpleBlockingStub extends io.grpc.stub.AbstractStub<SimpleBlockingStub> {
    private SimpleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单gRPC
     * </pre>
     */
    public io.grpc.MyResponse oneToOne(io.grpc.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ONE_TO_ONE, getCallOptions(), request);
    }

    /**
     * <pre>
     *服务端流
     * </pre>
     */
    public java.util.Iterator<io.grpc.MyResponse> oneToMany(
        io.grpc.MyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_ONE_TO_MANY, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SimpleFutureStub extends io.grpc.stub.AbstractStub<SimpleFutureStub> {
    private SimpleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单gRPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.MyResponse> oneToOne(
        io.grpc.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ONE_TO_ONE, getCallOptions()), request);
    }
  }

  private static final int METHODID_ONE_TO_ONE = 0;
  private static final int METHODID_ONE_TO_MANY = 1;
  private static final int METHODID_MANY_TO_ONE = 2;
  private static final int METHODID_MANY_TO_MANY = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SimpleImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(SimpleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ONE_TO_ONE:
          serviceImpl.oneToOne((io.grpc.MyRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.MyResponse>) responseObserver);
          break;
        case METHODID_ONE_TO_MANY:
          serviceImpl.oneToMany((io.grpc.MyRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.MyResponse>) responseObserver);
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
        case METHODID_MANY_TO_ONE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.manyToOne(
              (io.grpc.stub.StreamObserver<io.grpc.MyResponse>) responseObserver);
        case METHODID_MANY_TO_MANY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.manyToMany(
              (io.grpc.stub.StreamObserver<io.grpc.MyResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_ONE_TO_ONE,
        METHOD_ONE_TO_MANY,
        METHOD_MANY_TO_ONE,
        METHOD_MANY_TO_MANY);
  }

}
