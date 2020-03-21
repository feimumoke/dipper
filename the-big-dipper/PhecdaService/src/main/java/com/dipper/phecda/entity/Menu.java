package com.dipper.phecda.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 8571011372410167901L;

    // 菜单
   // public static final String TYPE_MENU = "0";
    // 按钮
   // public static final String TYPE_BUTTON = "1";

    //public static final int TOP_NODE = 0;

    /**
     * 菜单/按钮ID
     */

    private long menuId;

    /**
     * 排序
     */

    private long orderNum;


    /**
     * 上级菜单ID
     */

    private long parentId;

    /**
     * 菜单/按钮名称
     */

    private String menuName;

    /**
     * 菜单URL
     */

    private String url;

    /**
     * 权限标识
     */

    private String perms;

    /**
     * 图标
     */

    private String icon;

    /**
     * 类型 0菜单 1按钮
     */

    private String type;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
