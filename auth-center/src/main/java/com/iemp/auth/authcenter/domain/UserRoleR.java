package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 用户角色关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:36:53
 */
public class UserRoleR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 角色Id
     */
    private String roleId;


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

}