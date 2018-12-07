package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 菜单
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:34:15
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单路径
     */
    private String url;

    /**
     * 上级id
     */
    private String pId;

    /**
     * 菜单图标路径
     */
    private String picUrl;

    /**
     * 菜单类型 0为按钮  1为菜单
     */
    private String type;

    /**
     * 排序
     */
    private int sort;

    /**
     * 菜单描述
     */
    private String des;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}