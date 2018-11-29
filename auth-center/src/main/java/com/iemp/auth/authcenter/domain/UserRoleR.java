package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 角色用户关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:40:49
 */
public class UserRoleR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 业务id
     */
    private String ywId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getYwId() {
        return ywId;
    }

    public void setYwId(String ywId) {
        this.ywId = ywId;
    }

}