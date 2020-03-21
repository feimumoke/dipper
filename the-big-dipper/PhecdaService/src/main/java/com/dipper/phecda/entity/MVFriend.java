package com.dipper.phecda.entity;

import lombok.Data;

import java.util.List;

@Data
public class MVFriend {

    private String groupname;
    private Integer id;
    private Integer online;
    private List<MVUser> list;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public List<MVUser> getList() {
        return list;
    }

    public void setList(List<MVUser> list) {
        this.list = list;
    }
}
