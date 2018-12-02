package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 角色业务表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:11:56
 */
public class RoleBusiness implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 类的主键
     */
    private String classPk;

    /**
     * 类名
     */
    private String className;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getClassPk() {
        return classPk;
    }

    public void setClassPk(String classPk) {
        this.classPk = classPk;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}