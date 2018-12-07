package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 用户表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 11:31:16
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 上次登录时间
     */
    private String lastLogintIme;

    /**
     * 用户状态默认 0:启用
     */
    private int status;

    /**
     * 备用字段1
     */
    private String extend1;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastLogintIme() {
        return lastLogintIme;
    }

    public void setLastLogintIme(String lastLogintIme) {
        this.lastLogintIme = lastLogintIme;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

}