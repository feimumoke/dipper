package com.dipper.proto.utils;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

public class ProtobufUtils {
    @SuppressWarnings("unchecked")
    public static <T> T jsonToPf(String json, Message.Builder builder) throws InvalidProtocolBufferException {
        if (builder == null) {
            return null;
        }
        JsonFormat.parser().ignoringUnknownFields().merge(json, builder);
        return (T) builder.build();
    }

    public static <T> T objectToPf(Object entity, Message.Builder builder) throws InvalidProtocolBufferException {
        if (builder == null || entity == null) {
            return null;
        }
        return jsonToPf(JSONParserUtils.object2JsonString(entity), builder);
    }

    public static String pfToJson(Message message) throws InvalidProtocolBufferException {
        return JsonFormat.printer().print(message);
    }
}
