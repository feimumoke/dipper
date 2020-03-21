package com.dipper.phecda.service.interf;

import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.rpc.*;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import net.devh.boot.grpc.client.inject.GrpcClient;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsBaseService<T extends Message> implements IBaseService {

    protected MessageType type;


    @GrpcClient(RpcCommonConstant.MERAK_SERVICE)
    protected BaseServiceGrpc.BaseServiceBlockingStub baseStub;

    protected T unPack(Any data) {
        try {
            switch (type) {
                case USER:
                    return (T) data.unpack(UserPro.class);
                case FRIEND_MESSAGE:
                    return (T) data.unpack(FriendMessagePro.class);
                case FRIEND_TYPE:
                    return (T) data.unpack(FriendTypePro.class);
                case GROUP_USER:
                    return (T) data.unpack(GroupUserPro.class);
                case FRIEND:
                    return (T) data.unpack(FriendPro.class);
                case GROUP:
                    return (T) data.unpack(GroupPro.class);
                case GROUP_MESSAGE:
                    return (T) data.unpack(GroupMessagePro.class);
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    protected List<T> unPackList(Any data) {
        ArrayList<T> list = new ArrayList<>();
        try {
            System.out.println(data.getTypeUrl());
            DataList dataList = data.unpack(DataList.class);
            switch (type) {
                case USER:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(UserPro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case FRIEND_MESSAGE:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(FriendMessagePro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case FRIEND_TYPE:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(FriendTypePro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case GROUP_USER:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(GroupUserPro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case FRIEND:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(FriendPro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case GROUP:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(GroupPro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case GROUP_MESSAGE:
                    dataList.getDataList().forEach(d -> {
                        try {
                            list.add((T) d.unpack(GroupMessagePro.class));
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case UNRECOGNIZED:
                    System.out.println("UNRECOGNIZED");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }


}
