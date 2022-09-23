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
 * <pre>
 *定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: hello.proto")
public class HelloGrpc {

  private HelloGrpc() {}

  public static final String SERVICE_NAME = "hellotest.Hello";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.HelloRequest,
      io.grpc.HelloResponse> METHOD_TEST_HELLO_THING =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hellotest.Hello", "TestHelloThing"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.HelloRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.HelloResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloStub newStub(io.grpc.Channel channel) {
    return new HelloStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static HelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloFutureStub(channel);
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static abstract class HelloImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *注意：这里是returns 不是return
     * </pre>
     */
    public void testHelloThing(io.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_TEST_HELLO_THING, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_TEST_HELLO_THING,
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.HelloRequest,
                io.grpc.HelloResponse>(
                  this, METHODID_TEST_HELLO_THING)))
          .build();
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class HelloStub extends io.grpc.stub.AbstractStub<HelloStub> {
    private HelloStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloStub(channel, callOptions);
    }

    /**
     * <pre>
     *注意：这里是returns 不是return
     * </pre>
     */
    public void testHelloThing(io.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_TEST_HELLO_THING, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class HelloBlockingStub extends io.grpc.stub.AbstractStub<HelloBlockingStub> {
    private HelloBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *注意：这里是returns 不是return
     * </pre>
     */
    public io.grpc.HelloResponse testHelloThing(io.grpc.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_TEST_HELLO_THING, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class HelloFutureStub extends io.grpc.stub.AbstractStub<HelloFutureStub> {
    private HelloFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *注意：这里是returns 不是return
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.HelloResponse> testHelloThing(
        io.grpc.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_TEST_HELLO_THING, getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST_HELLO_THING = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(HelloImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST_HELLO_THING:
          serviceImpl.testHelloThing((io.grpc.HelloRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.HelloResponse>) responseObserver);
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

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_TEST_HELLO_THING);
  }

}
