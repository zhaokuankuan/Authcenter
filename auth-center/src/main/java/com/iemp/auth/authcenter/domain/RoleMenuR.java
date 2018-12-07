package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 角色菜单关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:39:07
 */
public class RoleMenuR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 角色Id
     */
    private String roleId;

    /**
     * 菜单Id
     */
    private String menuId;


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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

}