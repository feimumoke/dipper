package com.dipper.merak.service;


import com.dipper.merak.mapper.*;
import com.dipper.proto.entity.*;
import com.dipper.proto.rpc.RpcResult;
import com.dipper.proto.rpc.*;
import com.dipper.proto.utils.JSONParserUtils;
import com.dipper.proto.utils.ProtobufUtils;
import com.google.protobuf.Any;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

@GrpcService
public class BaseService extends AbsBaseService {
    @Override
    public void deleteByPropertyList(Entry request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper<?, Integer> mapper = getMapper(request.getType());
        Any data = request.getEntry();
        try {
            switch (request.getType()) {
                case USER:
                    UserPro userPro = data.unpack(UserPro.class);
                    User user = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(userPro), User.class);
                    ((UserMapper) mapper).delete(user);
                    break;
                case GROUP:
                    GroupPro groupPro = data.unpack(GroupPro.class);
                    Group group = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupPro), Group.class);
                    ((GroupMapper) mapper).delete(group);
                    break;
                case FRIEND:
                    FriendPro friendPro = data.unpack(FriendPro.class);
                    Friend friend = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendPro), Friend.class);
                    ((FriendMapper) mapper).delete(friend);
                    break;
                case GROUP_USER:
                    GroupUserPro groupUser = data.unpack(GroupUserPro.class);
                    GroupUser groupUser1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupUser), GroupUser.class);
                    ((GroupUserMapper) mapper).delete(groupUser1);
                    break;
                case FRIEND_TYPE:
                    FriendTypePro friendType = data.unpack(FriendTypePro.class);
                    FriendType friendType1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendType), FriendType.class);
                    ((FriendTypeMapper) mapper).delete(friendType1);
                    break;
                case FRIEND_MESSAGE:
                    FriendMessagePro friendMessage = data.unpack(FriendMessagePro.class);
                    FriendMessage friendMessage1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendMessage), FriendMessage.class);
                    ((FriendMessageMapper) mapper).delete(friendMessage1);
                    break;
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void selectByProperty(Entry request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper<?, Integer> mapper = getMapper(request.getType());
        Any data = request.getEntry();
        System.out.println(data.getTypeUrl());
        try {
            switch (request.getType()) {
                case USER:
                    UserPro userPro = data.unpack(UserPro.class);
                    User user = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(userPro), User.class);
                    Example<User> userExample = Example.of(user);
                    User result = ((UserMapper) mapper).findOne(userExample).orElse(null);
                    loadData(responseObserver, result != null, result, request.getType());
                    break;
                case GROUP:
                    GroupPro groupPro = data.unpack(GroupPro.class);
                    Group group = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupPro), Group.class);
                    Example<Group> groupExample = Example.of(group);
                    Group group2 = ((GroupMapper) mapper).findOne(groupExample).orElse(null);
                    loadData(responseObserver, group2 != null, group2, request.getType());
                    break;
                case FRIEND:
                    FriendPro friendPro = data.unpack(FriendPro.class);
                    Friend friend = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendPro), Friend.class);
                    Example<Friend> friendExample = Example.of(friend);
                    Friend friend1 = ((FriendMapper) mapper).findOne(friendExample).orElse(null);
                    loadData(responseObserver, friend1 != null, friend1, request.getType());
                    break;
                case GROUP_USER:
                    GroupUserPro groupUser = data.unpack(GroupUserPro.class);
                    GroupUser groupUser1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupUser), GroupUser.class);
                    Example<GroupUser> groupUserExample = Example.of(groupUser1);
                    GroupUser groupUser2 = ((GroupUserMapper) mapper).findOne(groupUserExample).orElse(null);
                    loadData(responseObserver, groupUser2 != null, groupUser2, request.getType());
                    break;
                case FRIEND_TYPE:
                    FriendTypePro friendType = data.unpack(FriendTypePro.class);
                    FriendType friendType1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendType), FriendType.class);
                    Example<FriendType> friendTypeExample = Example.of(friendType1);
                    FriendType friendType2 = ((FriendTypeMapper) mapper).findOne(friendTypeExample).orElse(null);
                    loadData(responseObserver, friendType2 != null, friendType2, request.getType());
                    break;
                case FRIEND_MESSAGE:
                    FriendMessagePro friendMessage = data.unpack(FriendMessagePro.class);
                    FriendMessage friendMessage1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendMessage), FriendMessage.class);
                    Example<FriendMessage> friendMessageExample = Example.of(friendMessage1);
                    FriendMessage friendMessage2 = ((FriendMessageMapper) mapper).findOne(friendMessageExample).orElse(null);
                    loadData(responseObserver, friendMessage2 != null, friendMessage2, request.getType());
                    break;
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }


    @Override
    public void selectListByProperty(Entry request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper<?, Integer> mapper = getMapper(request.getType());
        System.out.println("selectListByProperty");
        Any data = request.getEntry();
        try {
            switch (request.getType()) {
                case USER:
                    UserPro userPro = data.unpack(UserPro.class);
                    User user = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(userPro), User.class);
                    Example<User> userExample = Example.of(user);
                    List<User> all = ((UserMapper) mapper).findAll(userExample);
                    allPack(request, responseObserver, all);
                    break;
                case GROUP:
                    GroupPro groupPro = data.unpack(GroupPro.class);
                    Group group = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupPro), Group.class);
                    Example<Group> groupExample = Example.of(group);
                    List<Group> all1 = ((GroupMapper) mapper).findAll(groupExample);
                    allPack(request, responseObserver, all1);
                    break;
                case FRIEND:
                    FriendPro friendPro = data.unpack(FriendPro.class);
                    Friend friend = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendPro), Friend.class);
                    Example<Friend> friendExample = Example.of(friend);
                    List<Friend> all2 = ((FriendMapper) mapper).findAll(friendExample);
                    allPack(request, responseObserver, all2);
                    break;
                case GROUP_USER:
                    GroupUserPro groupUser = data.unpack(GroupUserPro.class);
                    GroupUser groupUser1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(groupUser), GroupUser.class);
                    Example<GroupUser> groupUserExample = Example.of(groupUser1);
                    List<GroupUser> all3 = ((GroupUserMapper) mapper).findAll(groupUserExample);
                    allPack(request, responseObserver, all3);
                    break;
                case FRIEND_TYPE:
                    FriendTypePro friendType = data.unpack(FriendTypePro.class);
                    FriendType friendType1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendType), FriendType.class);
                    Example<FriendType> friendTypeExample = Example.of(friendType1);
                    List<FriendType> all4 = ((FriendTypeMapper) mapper).findAll(friendTypeExample);
                    allPack(request, responseObserver, all4);
                    break;
                case FRIEND_MESSAGE:
                    FriendMessagePro friendMessage = data.unpack(FriendMessagePro.class);
                    FriendMessage friendMessage1 = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(friendMessage), FriendMessage.class);
                    Example<FriendMessage> friendMessageExample = Example.of(friendMessage1);
                    List<FriendMessage> all5 = ((FriendMessageMapper) mapper).findAll(friendMessageExample);
                    allPack(request, responseObserver, all5);
                    break;
                case UNRECOGNIZED:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            responseObserver.onCompleted();
        }
    }


    @Override
    public void save(Entry request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper mapper = getMapper(request.getType());
        Any entry = request.getEntry();
        try {
            Object save = mapper.save(unPack(entry, request.getType()));
            RpcResult.Builder builder = okRpcResult();
            loadInfo(builder, save, request.getType());
            responseObserver.onNext(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            RpcResult.Builder builder = errRpcResult();
            responseObserver.onNext(builder.build());
        } finally {
            responseObserver.onCompleted();
        }
    }


    @Override
    public void update(Entry request, StreamObserver<RpcResult> responseObserver) {
        save(request, responseObserver);
    }

    @Override
    public void selectById(KeyId request, StreamObserver<RpcResult> responseObserver) {
        System.out.println("selectById");
        BaseMapper mapper = getMapper(request.getType());
        Optional optional = mapper.findById(request.getKeyId());
        try {
            loadData(responseObserver, optional.isPresent(), optional.get(), request.getType());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void selectAll(Empty request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper<?, Integer> mapper = getMapper(request.getType());
        List<?> all = mapper.findAll();
        allPack(request, responseObserver, all);
        responseObserver.onCompleted();
    }


    @Override
    public void selectPageList(PageInfo request, StreamObserver<RpcResult> responseObserver) {
        BaseMapper<?, Integer> mapper = getMapper(request.getType());
        Pageable pageRequest = PageRequest.of(request.getPageNum(), request.getPageSize(), Sort.Direction.ASC);
        Page<?> all = mapper.findAll(pageRequest);
        allPack(request, responseObserver, all);
        responseObserver.onCompleted();
    }
}
