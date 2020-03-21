package com.dipper.merak.service;

import com.dipper.merak.mapper.*;
import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.entity.*;
import com.dipper.proto.rpc.*;
import com.dipper.proto.utils.JSONParserUtils;
import com.dipper.proto.utils.ProtobufUtils;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;
import jdk.nashorn.internal.runtime.ListAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Streamable;

import java.util.List;


public abstract class AbsBaseService extends BaseServiceGrpc.BaseServiceImplBase {

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected FriendMapper friendMapper;

    @Autowired
    protected FriendMessageMapper friendMessageMapper;

    @Autowired
    protected FriendTypeMapper friendTypeMapper;

    @Autowired
    protected GroupMapper groupMapper;

    @Autowired
    protected GroupUserMapper groupUserMapper;

    @Autowired
    protected GroupMessageMapper groupMessageMapper;

    public BaseMapper<? extends Object, Integer> getMapper(MessageType type) {
        switch (type) {
            case USER:
                return userMapper;
            case GROUP:
                return groupMapper;
            case FRIEND:
                return friendMapper;
            case GROUP_USER:
                return groupUserMapper;
            case FRIEND_TYPE:
                return friendTypeMapper;
            case FRIEND_MESSAGE:
                return friendMessageMapper;
            case GROUP_MESSAGE:
                return groupMessageMapper;
            case UNRECOGNIZED:
                return null;
        }
        return null;
    }


    protected RpcResult.Builder okRpcResult() {
        return RpcResult.newBuilder().setRpcCode(RpcCommonConstant.RESULT_OK).setMessage(RpcCommonConstant.RESULT_SUCCESS_STR);
    }

    protected RpcResult.Builder errRpcResult() {
        return RpcResult.newBuilder().setRpcCode(RpcCommonConstant.RESULT_OK).setMessage(RpcCommonConstant.RESULT_SUCCESS_STR);
    }

    protected RpcResult.Builder nullRpcResult() {
        return RpcResult.newBuilder().setRpcCode(RpcCommonConstant.RESULT_NULL).setMessage(RpcCommonConstant.RESULT_FAIL_NULL);
    }

    @Override
    public void deleteById(KeyId request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper mapper = getMapper(request.getType());
        int id = request.getKeyId();
        try {
            mapper.deleteById(id);
            RpcResult.Builder builder = okRpcResult();
            responseObserver.onNext(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            RpcResult.Builder builder = errRpcResult();
            responseObserver.onNext(builder.build());
        } finally {
            responseObserver.onCompleted();
        }
    }

    protected void loadInfo(RpcResult.Builder builder, Object object, MessageType type) {
        try {
            switch (type) {
                case USER:
                    UserPro user = ProtobufUtils.objectToPf(object, UserPro.newBuilder());
                    builder.setData(Any.pack(user));
                    break;
                case GROUP:
                    GroupPro group = ProtobufUtils.objectToPf(object, GroupPro.newBuilder());
                    builder.setData(Any.pack(group));
                    break;
                case FRIEND:
                    FriendPro friend = ProtobufUtils.objectToPf(object, FriendPro.newBuilder());
                    builder.setData(Any.pack(friend));
                    break;
                case GROUP_USER:
                    GroupUserPro groupUser = ProtobufUtils.objectToPf(object, GroupUserPro.newBuilder());
                    builder.setData(Any.pack(groupUser));
                    break;
                case FRIEND_TYPE:
                    FriendTypePro friendType = ProtobufUtils.objectToPf(object, FriendTypePro.newBuilder());
                    builder.setData(Any.pack(friendType));
                    break;
                case FRIEND_MESSAGE:
                    FriendMessagePro friendMessage = ProtobufUtils.objectToPf(object, FriendMessagePro.newBuilder());
                    builder.setData(Any.pack(friendMessage));
                    break;
                case GROUP_MESSAGE:
                    GroupMessagePro groupMessagePro = ProtobufUtils.objectToPf(object, GroupMessagePro.newBuilder());
                    builder.setData(Any.pack(groupMessagePro));
                    break;
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadInfoList(RpcResult.Builder builder, Iterable object, MessageType type) {
        DataList.Builder dataList = DataList.newBuilder();
        try {
            switch (type) {
                case USER:
                    object.forEach(o -> {
                        try {
                            dataList.addData(Any.pack(ProtobufUtils.objectToPf(o, UserPro.newBuilder())));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case GROUP:
                    object.forEach(o -> {
                        try {
                            dataList.addData(Any.pack(ProtobufUtils.objectToPf(o, GroupPro.newBuilder())));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case FRIEND:
                    object.forEach(o -> {
                        try {
                            dataList.addData(Any.pack(ProtobufUtils.objectToPf(o, FriendPro.newBuilder())));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case GROUP_USER:
                    object.forEach(o -> {
                        try {
                            dataList.addData(Any.pack(ProtobufUtils.objectToPf(o, GroupUserPro.newBuilder())));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case FRIEND_TYPE:
                    object.forEach(o -> {
                        try {
                            dataList.addData(Any.pack(ProtobufUtils.objectToPf(o, FriendTypePro.newBuilder())));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case FRIEND_MESSAGE:
                    object.forEach(o -> {
                        try {
                            dataList.addData(Any.pack(ProtobufUtils.objectToPf(o, FriendMessagePro.newBuilder())));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(dataList);
            builder.setData(Any.pack(dataList.build()));
        }
    }

    protected Object unPack(Any data, MessageType type) {

        try {
            switch (type) {
                case USER:
                    UserPro userPro = data.unpack(UserPro.class);
                    return JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(userPro), User.class);
                case GROUP:
                    GroupPro groupPro = data.unpack(GroupPro.class);
                    return JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupPro), Group.class);
                case FRIEND:
                    FriendPro friendPro = data.unpack(FriendPro.class);
                    return JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendPro), Friend.class);
                case GROUP_USER:
                    GroupUserPro groupUser = data.unpack(GroupUserPro.class);
                    return JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupUser), GroupUser.class);
                case FRIEND_TYPE:
                    FriendTypePro friendType = data.unpack(FriendTypePro.class);
                    return JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendType), FriendType.class);
                case FRIEND_MESSAGE:
                    FriendMessagePro friendMessage = data.unpack(FriendMessagePro.class);
                    System.out.println(friendMessage.getIsBack());
                    System.out.println(friendMessage.getIsDel());
                    System.out.println(friendMessage.getIsRead());
                    FriendMessage friendMessage1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendMessage), FriendMessage.class);
                    friendMessage1.setIsBack(friendMessage.getIsBack());
                    friendMessage1.setIsDel(friendMessage.getIsDel());
                    friendMessage1.setIsRead(friendMessage.getIsRead());
                    return friendMessage1;
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void loadData(StreamObserver<RpcResult> responseObserver, boolean b, Object result2, MessageType type) {
        if (b) {
            RpcResult.Builder builder = okRpcResult();
            loadInfo(builder, result2, type);
            responseObserver.onNext(builder.build());
        } else {
            responseObserver.onNext(nullRpcResult().build());
        }
    }

    protected void allPack(Message request, StreamObserver<RpcResult> responseObserver, Iterable<?> all) {
        if (all instanceof List && ((List<?>) all).isEmpty()) {
            responseObserver.onNext(nullRpcResult().build());
        } else if (all instanceof Page && ((Page<?>) all).isEmpty()) {
            responseObserver.onNext(nullRpcResult().build());
        } else {
            RpcResult.Builder builder = okRpcResult();
            if (request instanceof Empty) {
                loadInfoList(builder, all, ((Empty) request).getType());
                responseObserver.onNext(builder.build());
            } else if (request instanceof PageInfo) {
                loadInfoList(builder, all, ((PageInfo) request).getType());
                responseObserver.onNext(builder.build());
            }
            if (request instanceof Entry) {
                loadInfoList(builder, all, ((Entry) request).getType());
                responseObserver.onNext(builder.build());
            }
        }
    }
}
