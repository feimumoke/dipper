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
    comments = "Source: BaseService.proto")
public final class BaseServiceGrpc {

  private BaseServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dipper.proto.rpc.BaseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getSaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "save",
      requestType = com.dipper.proto.rpc.Entry.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getSaveMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult> getSaveMethod;
    if ((getSaveMethod = BaseServiceGrpc.getSaveMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getSaveMethod = BaseServiceGrpc.getSaveMethod) == null) {
          BaseServiceGrpc.getSaveMethod = getSaveMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "save"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("save"))
              .build();
        }
      }
    }
    return getSaveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.KeyId,
      com.dipper.proto.rpc.RpcResult> getDeleteByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteById",
      requestType = com.dipper.proto.rpc.KeyId.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.KeyId,
      com.dipper.proto.rpc.RpcResult> getDeleteByIdMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.KeyId, com.dipper.proto.rpc.RpcResult> getDeleteByIdMethod;
    if ((getDeleteByIdMethod = BaseServiceGrpc.getDeleteByIdMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getDeleteByIdMethod = BaseServiceGrpc.getDeleteByIdMethod) == null) {
          BaseServiceGrpc.getDeleteByIdMethod = getDeleteByIdMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.KeyId, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.KeyId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("deleteById"))
              .build();
        }
      }
    }
    return getDeleteByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getDeleteByPropertyListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteByPropertyList",
      requestType = com.dipper.proto.rpc.Entry.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getDeleteByPropertyListMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult> getDeleteByPropertyListMethod;
    if ((getDeleteByPropertyListMethod = BaseServiceGrpc.getDeleteByPropertyListMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getDeleteByPropertyListMethod = BaseServiceGrpc.getDeleteByPropertyListMethod) == null) {
          BaseServiceGrpc.getDeleteByPropertyListMethod = getDeleteByPropertyListMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteByPropertyList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("deleteByPropertyList"))
              .build();
        }
      }
    }
    return getDeleteByPropertyListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = com.dipper.proto.rpc.Entry.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult> getUpdateMethod;
    if ((getUpdateMethod = BaseServiceGrpc.getUpdateMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getUpdateMethod = BaseServiceGrpc.getUpdateMethod) == null) {
          BaseServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.KeyId,
      com.dipper.proto.rpc.RpcResult> getSelectByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectById",
      requestType = com.dipper.proto.rpc.KeyId.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.KeyId,
      com.dipper.proto.rpc.RpcResult> getSelectByIdMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.KeyId, com.dipper.proto.rpc.RpcResult> getSelectByIdMethod;
    if ((getSelectByIdMethod = BaseServiceGrpc.getSelectByIdMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getSelectByIdMethod = BaseServiceGrpc.getSelectByIdMethod) == null) {
          BaseServiceGrpc.getSelectByIdMethod = getSelectByIdMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.KeyId, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.KeyId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("selectById"))
              .build();
        }
      }
    }
    return getSelectByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.Empty,
      com.dipper.proto.rpc.RpcResult> getSelectAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectAll",
      requestType = com.dipper.proto.rpc.Empty.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.Empty,
      com.dipper.proto.rpc.RpcResult> getSelectAllMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.Empty, com.dipper.proto.rpc.RpcResult> getSelectAllMethod;
    if ((getSelectAllMethod = BaseServiceGrpc.getSelectAllMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getSelectAllMethod = BaseServiceGrpc.getSelectAllMethod) == null) {
          BaseServiceGrpc.getSelectAllMethod = getSelectAllMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.Empty, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("selectAll"))
              .build();
        }
      }
    }
    return getSelectAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getSelectByPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectByProperty",
      requestType = com.dipper.proto.rpc.Entry.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getSelectByPropertyMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult> getSelectByPropertyMethod;
    if ((getSelectByPropertyMethod = BaseServiceGrpc.getSelectByPropertyMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getSelectByPropertyMethod = BaseServiceGrpc.getSelectByPropertyMethod) == null) {
          BaseServiceGrpc.getSelectByPropertyMethod = getSelectByPropertyMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectByProperty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("selectByProperty"))
              .build();
        }
      }
    }
    return getSelectByPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getSelectListByPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectListByProperty",
      requestType = com.dipper.proto.rpc.Entry.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry,
      com.dipper.proto.rpc.RpcResult> getSelectListByPropertyMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult> getSelectListByPropertyMethod;
    if ((getSelectListByPropertyMethod = BaseServiceGrpc.getSelectListByPropertyMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getSelectListByPropertyMethod = BaseServiceGrpc.getSelectListByPropertyMethod) == null) {
          BaseServiceGrpc.getSelectListByPropertyMethod = getSelectListByPropertyMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.Entry, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectListByProperty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("selectListByProperty"))
              .build();
        }
      }
    }
    return getSelectListByPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dipper.proto.rpc.PageInfo,
      com.dipper.proto.rpc.RpcResult> getSelectPageListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectPageList",
      requestType = com.dipper.proto.rpc.PageInfo.class,
      responseType = com.dipper.proto.rpc.RpcResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dipper.proto.rpc.PageInfo,
      com.dipper.proto.rpc.RpcResult> getSelectPageListMethod() {
    io.grpc.MethodDescriptor<com.dipper.proto.rpc.PageInfo, com.dipper.proto.rpc.RpcResult> getSelectPageListMethod;
    if ((getSelectPageListMethod = BaseServiceGrpc.getSelectPageListMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getSelectPageListMethod = BaseServiceGrpc.getSelectPageListMethod) == null) {
          BaseServiceGrpc.getSelectPageListMethod = getSelectPageListMethod =
              io.grpc.MethodDescriptor.<com.dipper.proto.rpc.PageInfo, com.dipper.proto.rpc.RpcResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectPageList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.PageInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dipper.proto.rpc.RpcResult.getDefaultInstance()))
              .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("selectPageList"))
              .build();
        }
      }
    }
    return getSelectPageListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BaseServiceStub newStub(io.grpc.Channel channel) {
    return new BaseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BaseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BaseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BaseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BaseServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BaseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void save(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveMethod(), responseObserver);
    }

    /**
     */
    public void deleteById(com.dipper.proto.rpc.KeyId request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteByIdMethod(), responseObserver);
    }

    /**
     */
    public void deleteByPropertyList(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteByPropertyListMethod(), responseObserver);
    }

    /**
     */
    public void update(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void selectById(com.dipper.proto.rpc.KeyId request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectByIdMethod(), responseObserver);
    }

    /**
     */
    public void selectAll(com.dipper.proto.rpc.Empty request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectAllMethod(), responseObserver);
    }

    /**
     */
    public void selectByProperty(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectByPropertyMethod(), responseObserver);
    }

    /**
     */
    public void selectListByProperty(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectListByPropertyMethod(), responseObserver);
    }

    /**
     */
    public void selectPageList(com.dipper.proto.rpc.PageInfo request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectPageListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.Entry,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_SAVE)))
          .addMethod(
            getDeleteByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.KeyId,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_DELETE_BY_ID)))
          .addMethod(
            getDeleteByPropertyListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.Entry,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_DELETE_BY_PROPERTY_LIST)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.Entry,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getSelectByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.KeyId,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_SELECT_BY_ID)))
          .addMethod(
            getSelectAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.Empty,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_SELECT_ALL)))
          .addMethod(
            getSelectByPropertyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.Entry,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_SELECT_BY_PROPERTY)))
          .addMethod(
            getSelectListByPropertyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.Entry,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_SELECT_LIST_BY_PROPERTY)))
          .addMethod(
            getSelectPageListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dipper.proto.rpc.PageInfo,
                com.dipper.proto.rpc.RpcResult>(
                  this, METHODID_SELECT_PAGE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class BaseServiceStub extends io.grpc.stub.AbstractStub<BaseServiceStub> {
    private BaseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BaseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BaseServiceStub(channel, callOptions);
    }

    /**
     */
    public void save(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteById(com.dipper.proto.rpc.KeyId request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteByPropertyList(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteByPropertyListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectById(com.dipper.proto.rpc.KeyId request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectAll(com.dipper.proto.rpc.Empty request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectByProperty(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectByPropertyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectListByProperty(com.dipper.proto.rpc.Entry request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectListByPropertyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectPageList(com.dipper.proto.rpc.PageInfo request,
        io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectPageListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BaseServiceBlockingStub extends io.grpc.stub.AbstractStub<BaseServiceBlockingStub> {
    private BaseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BaseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BaseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult save(com.dipper.proto.rpc.Entry request) {
      return blockingUnaryCall(
          getChannel(), getSaveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult deleteById(com.dipper.proto.rpc.KeyId request) {
      return blockingUnaryCall(
          getChannel(), getDeleteByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult deleteByPropertyList(com.dipper.proto.rpc.Entry request) {
      return blockingUnaryCall(
          getChannel(), getDeleteByPropertyListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult update(com.dipper.proto.rpc.Entry request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult selectById(com.dipper.proto.rpc.KeyId request) {
      return blockingUnaryCall(
          getChannel(), getSelectByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult selectAll(com.dipper.proto.rpc.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSelectAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult selectByProperty(com.dipper.proto.rpc.Entry request) {
      return blockingUnaryCall(
          getChannel(), getSelectByPropertyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult selectListByProperty(com.dipper.proto.rpc.Entry request) {
      return blockingUnaryCall(
          getChannel(), getSelectListByPropertyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dipper.proto.rpc.RpcResult selectPageList(com.dipper.proto.rpc.PageInfo request) {
      return blockingUnaryCall(
          getChannel(), getSelectPageListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BaseServiceFutureStub extends io.grpc.stub.AbstractStub<BaseServiceFutureStub> {
    private BaseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BaseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BaseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> save(
        com.dipper.proto.rpc.Entry request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> deleteById(
        com.dipper.proto.rpc.KeyId request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> deleteByPropertyList(
        com.dipper.proto.rpc.Entry request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteByPropertyListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> update(
        com.dipper.proto.rpc.Entry request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> selectById(
        com.dipper.proto.rpc.KeyId request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> selectAll(
        com.dipper.proto.rpc.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> selectByProperty(
        com.dipper.proto.rpc.Entry request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectByPropertyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> selectListByProperty(
        com.dipper.proto.rpc.Entry request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectListByPropertyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dipper.proto.rpc.RpcResult> selectPageList(
        com.dipper.proto.rpc.PageInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectPageListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE = 0;
  private static final int METHODID_DELETE_BY_ID = 1;
  private static final int METHODID_DELETE_BY_PROPERTY_LIST = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_SELECT_BY_ID = 4;
  private static final int METHODID_SELECT_ALL = 5;
  private static final int METHODID_SELECT_BY_PROPERTY = 6;
  private static final int METHODID_SELECT_LIST_BY_PROPERTY = 7;
  private static final int METHODID_SELECT_PAGE_LIST = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BaseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BaseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE:
          serviceImpl.save((com.dipper.proto.rpc.Entry) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_DELETE_BY_ID:
          serviceImpl.deleteById((com.dipper.proto.rpc.KeyId) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_DELETE_BY_PROPERTY_LIST:
          serviceImpl.deleteByPropertyList((com.dipper.proto.rpc.Entry) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.dipper.proto.rpc.Entry) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_SELECT_BY_ID:
          serviceImpl.selectById((com.dipper.proto.rpc.KeyId) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_SELECT_ALL:
          serviceImpl.selectAll((com.dipper.proto.rpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_SELECT_BY_PROPERTY:
          serviceImpl.selectByProperty((com.dipper.proto.rpc.Entry) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_SELECT_LIST_BY_PROPERTY:
          serviceImpl.selectListByProperty((com.dipper.proto.rpc.Entry) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
          break;
        case METHODID_SELECT_PAGE_LIST:
          serviceImpl.selectPageList((com.dipper.proto.rpc.PageInfo) request,
              (io.grpc.stub.StreamObserver<com.dipper.proto.rpc.RpcResult>) responseObserver);
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

  private static abstract class BaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BaseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dipper.proto.rpc.DipperService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BaseService");
    }
  }

  private static final class BaseServiceFileDescriptorSupplier
      extends BaseServiceBaseDescriptorSupplier {
    BaseServiceFileDescriptorSupplier() {}
  }

  private static final class BaseServiceMethodDescriptorSupplier
      extends BaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BaseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BaseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BaseServiceFileDescriptorSupplier())
              .addMethod(getSaveMethod())
              .addMethod(getDeleteByIdMethod())
              .addMethod(getDeleteByPropertyListMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getSelectByIdMethod())
              .addMethod(getSelectAllMethod())
              .addMethod(getSelectByPropertyMethod())
              .addMethod(getSelectListByPropertyMethod())
              .addMethod(getSelectPageListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
