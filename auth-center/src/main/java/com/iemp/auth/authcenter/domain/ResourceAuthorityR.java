package com.iemp.auth.authcenter.domain;

import java.io.Serializable;
/**
 * 资源操作码关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:06:53
 */
public class ResourceAuthorityR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 操作码id
     */
    private String authorityId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

}