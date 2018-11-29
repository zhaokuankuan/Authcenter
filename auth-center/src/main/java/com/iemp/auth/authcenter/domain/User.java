package com.iemp.auth.authcenter.domain;

/**
 * @author :Mr.kk
 * @date: 2018/11/29 18:57
 */
public class User {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 登陆名称
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
