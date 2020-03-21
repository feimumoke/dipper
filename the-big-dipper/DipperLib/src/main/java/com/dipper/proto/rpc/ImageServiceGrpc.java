package com.dipper.proto.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: ImageService.proto")
public final class ImageServiceGrpc {

  private ImageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dipper.proto.rpc.ImageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.ImageData,
      com.dipper.proto.rpc.ImageSaveResult> getSaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "save",
      requestType = com.dipper.proto.rpc.ImageData.class,
      responseType = com.dipper.proto.rpc.ImageSaveResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.ImageData,
      com.dipper.proto.rpc.ImageSaveResult> getSaveMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.ImageData, com.dipper.proto.rpc.ImageSaveResult> getSaveMethod;
    if ((getSaveMethod = ImageServiceGrpc.getSaveMethod) == null) {
      synchronized (ImageServiceGrpc.class) {
        if ((getSaveMethod = ImageServiceGrpc.getSaveMethod) == null) {
          ImageServiceGrpc.getSaveMethod = getSaveMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.ImageData, com.dipper.proto.rpc.ImageSaveResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "save"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.ImageData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.ImageSaveResult.getDefaultInstance()))
              .setSchemaDescriptor(new ImageServiceMethodDescriptorSupplier("save"))
              .build();
        }
      }
    }
    return getSaveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.ImagePath,
      com.dipper.proto.rpc.ImageLoadResult> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "download",
      requestType = com.dipper.proto.rpc.ImagePath.class,
      responseType = com.dipper.proto.rpc.ImageLoadResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.ImagePath,
      com.dipper.proto.rpc.ImageLoadResult> getDownloadMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.ImagePath, com.dipper.proto.rpc.ImageLoadResult> getDownloadMethod;
    if ((getDownloadMethod = ImageServiceGrpc.getDownloadMethod) == null) {
      synchronized (ImageServiceGrpc.class) {
        if ((getDownloadMethod = ImageServiceGrpc.getDownloadMethod) == null) {
          ImageServiceGrpc.getDownloadMethod = getDownloadMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.ImagePath, com.dipper.proto.rpc.ImageLoadResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.ImagePath.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.ImageLoadResult.getDefaultInstance()))
              .setSchemaDescriptor(new ImageServiceMethodDescriptorSupplier("download"))
              .build();
        }
      }
    }
    return getDownloadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ImageServiceStub newStub(io.grpc.Channel channel) {
    return new ImageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ImageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ImageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ImageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ImageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void save(com.dipper.proto.rpc.ImageData request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.ImageSaveResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveMethod(), responseObserver);
    }

    /**
     */
    public void download(com.dipper.proto.rpc.ImagePath request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.ImageLoadResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.ImageData,
                com.dipper.proto.rpc.ImageSaveResult>(
                  this, METHODID_SAVE)))
          .addMethod(
            getDownloadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.ImagePath,
                com.dipper.proto.rpc.ImageLoadResult>(
                  this, METHODID_DOWNLOAD)))
          .build();
    }
  }

  /**
   */
  public static final class ImageServiceStub extends io.grpc.stub.AbstractStub<ImageServiceStub> {
    private ImageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImageServiceStub(channel, callOptions);
    }

    /**
     */
    public void save(com.dipper.proto.rpc.ImageData request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.ImageSaveResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void download(com.dipper.proto.rpc.ImagePath request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.ImageLoadResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ImageServiceBlockingStub extends io.grpc.stub.AbstractStub<ImageServiceBlockingStub> {
    private ImageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dipper.proto.rpc.ImageSaveResult save(com.dipper.proto.rpc.ImageData request) {
      return blockingUnaryCall(
          getChannel(), getSaveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.ImageLoadResult download(com.dipper.proto.rpc.ImagePath request) {
      return blockingUnaryCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ImageServiceFutureStub extends io.grpc.stub.AbstractStub<ImageServiceFutureStub> {
    private ImageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.ImageSaveResult> save(
        com.dipper.proto.rpc.ImageData request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.ImageLoadResult> download(
        com.dipper.proto.rpc.ImagePath request) {
      return futureUnaryCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE = 0;
  private static final int METHODID_DOWNLOAD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE:
          serviceImpl.save((com.dipper.proto.rpc.ImageData) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.ImageSaveResult>) responseObserver);
          break;
        case METHODID_DOWNLOAD:
          serviceImpl.download((com.dipper.proto.rpc.ImagePath) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.ImageLoadResult>) responseObserver);
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

  private static abstract class ImageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dipper.proto.rpc.ImageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImageService");
    }
  }

  private static final class ImageServiceFileDescriptorSupplier
      extends ImageServiceBaseDescriptorSupplier {
    ImageServiceFileDescriptorSupplier() {}
  }

  private static final class ImageServiceMethodDescriptorSupplier
      extends ImageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ImageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ImageServiceFileDescriptorSupplier())
              .addMethod(getSaveMethod())
              .addMethod(getDownloadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
