package com.dipper.phecda.entity;

import lombok.Data;

import java.util.List;

@Data
public class MVData {

    private MVUser mine;
    private List<MVFriend> friend;
    private List<MVGroup> group;

    public MVUser getMine() {
        return mine;
    }

    public void setMine(MVUser mine) {
        this.mine = mine;
    }

    public List<MVFriend> getFriend() {
        return friend;
    }

    public void setFriend(List<MVFriend> friend) {
        this.friend = friend;
    }

    public List<MVGroup> getGroup() {
        return group;
    }

    public void setGroup(List<MVGroup> group) {
        this.group = group;
    }
}
