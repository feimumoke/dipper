package com.dipper.phecda.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
public class RespResult<T> implements Serializable {

    private int resCode;
    private String resInfo;
   // @JsonIgnore
   // @JsonIgnoreProperties
    private T resData;

    public String getResInfo() {
        return resInfo;
    }

    public void setResInfo(String resInfo) {
        this.resInfo = resInfo;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }

    public RespResult success(){
        this.resCode=200;
        this.resInfo="SUCCESS";
        return this;
    }

    public RespResult() {
    }

    public RespResult(int resCode, String resInfo) {
        this.resCode = resCode;
        this.resInfo = resInfo;
    }
}
