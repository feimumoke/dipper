package com.dipper.proto.utils;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JSONParserUtils {
    private static Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();

    /**
     * Instantiates a new Json parse utils.
     */
    public JSONParserUtils() {
    }

    /**
     * Object 2 json string string.
     *
     * @param obj the obj
     * @return the string
     */
    public static String object2JsonString(Object obj) {
        return obj == null ? null : gson.toJson(obj);
    }

    /**
     * Json 2 object t.
     *
     * @param <T>        the type parameter
     * @param jsonString the json string
     * @param resultType the result type
     * @return the t
     */
    public static <T> T entry2Object(String jsonString, Class<T> resultType) {
        return Strings.isNullOrEmpty(jsonString) ? null : gson.fromJson(jsonString, resultType);
    }

    /**
     * Json 2 generic object t.
     *
     * @param <T>        the type parameter
     * @param jsonString the json string
     * @param typeToken  the type token
     * @return the t
     */
    public static <T> T json2GenericObject(String jsonString, TypeToken<T> typeToken) {
        return gson.fromJson(jsonString, typeToken.getType());
    }
}
