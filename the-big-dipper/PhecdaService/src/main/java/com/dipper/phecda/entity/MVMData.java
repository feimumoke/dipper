package com.dipper.phecda.entity;

import lombok.Data;

import java.util.List;

@Data
public class MVMData {

    private MVUser owner;

    private List<MVUser> list;

    public MVUser getOwner() {
        return owner;
    }

    public void setOwner(MVUser owner) {
        this.owner = owner;
    }

    public List<MVUser> getList() {
        return list;
    }

    public void setList(List<MVUser> list) {
        this.list = list;
    }
}
