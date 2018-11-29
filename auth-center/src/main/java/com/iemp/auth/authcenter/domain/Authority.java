package com.iemp.auth.authcenter.domain;
import java.io.Serializable;
/**
 * 操作码表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:33:17
 */
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 操作码名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 接口名称
     */
    private String url;

    /**
     * 方法
     */
    private String method;

    /**
     * controller
     */
    private String controller;

    /**
     * 描述
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
