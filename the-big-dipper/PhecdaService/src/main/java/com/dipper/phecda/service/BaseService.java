package com.dipper.phecda.service;

import com.dipper.phecda.service.interf.AbsBaseService;
import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.rpc.*;
import com.google.protobuf.Any;
import com.google.protobuf.Message;

import java.util.ArrayList;
import java.util.List;


public class BaseService<T extends Message> extends AbsBaseService<T> {


    public BaseService(MessageType realtype) {
        type = realtype;
    }


    @Override
    public T save(Message message) {
        Entry.Builder builder = Entry.newBuilder().setType(type).setEntry(Any.pack(message));
        RpcResult result = baseStub.save(builder.build());
        Any data = result.getData();
        if (result.getRpcCode() == RpcCommonConstant.RESULT_OK) {
            return unPack(data);
        } else {
            return null;
        }
    }

    @Override
    public T getById(Integer id) {
        KeyId keyId = KeyId.newBuilder().setType(type).setKeyId(id).build();
        RpcResult result = baseStub.selectById(keyId);
        Any data = result.getData();
        if (result.getRpcCode() == RpcCommonConstant.RESULT_OK) {
            return unPack(data);
        } else {
            return null;
        }
    }

    @Override
    public T update(Message message) {
        return save(message);
    }

    @Override
    public List selectAll() {
        RpcResult result = baseStub.selectAll(Empty.newBuilder().setType(type).build());
        if (result.getRpcCode() == RpcCommonConstant.RESULT_OK) {
            return unPackList(result.getData());
        } else {
            return new ArrayList();
        }
    }


    @Override
    public T selectOne(Message message) {
        Entry.Builder builder = Entry.newBuilder().setType(type).setEntry(Any.pack(message));
        RpcResult result = baseStub.selectByProperty(builder.build());
        Any data = result.getData();
        if (result.getRpcCode() == RpcCommonConstant.RESULT_OK) {
            return unPack(data);
        } else {
            return null;
        }
    }

    @Override
    public List<T> selectList(Message message) {
        Entry.Builder builder = Entry.newBuilder().setType(type).setEntry(Any.pack(message));
        RpcResult result = baseStub.selectListByProperty(builder.build());
        if (result.getRpcCode() == RpcCommonConstant.RESULT_OK) {
            return unPackList(result.getData());
        } else {
            return new ArrayList();
        }
    }

    @Override
    public List selectAndPaging(Message message, Integer pageNum, Integer pageSize) {
        PageInfo.Builder builder = PageInfo.newBuilder().setType(type).setPageNum(pageNum).setPageSize(pageSize);
        RpcResult rpcResult = baseStub.selectPageList(builder.build());
        if (rpcResult.getRpcCode() == RpcCommonConstant.RESULT_OK) {
            return unPackList(rpcResult.getData());
        } else {
            return new ArrayList();
        }
    }


}
