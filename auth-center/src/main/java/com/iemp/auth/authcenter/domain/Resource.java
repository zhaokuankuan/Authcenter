package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 资源表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:22:33
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源类型
     */
    private int type;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 上级资源id
     */
    private String pid;

    /**
     * 描述
     */
    private String des;

    /**
     * 序号
     */
    private int sort;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

}