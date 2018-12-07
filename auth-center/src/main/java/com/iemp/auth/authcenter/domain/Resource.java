package com.iemp.auth.authcenter.domain;
import java.io.Serializable;
/**
 * 资源
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:31:15
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
    private String name;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 增加 ：0 为拥有权限 1(默认) 没有权限
     */
    private int add;

    /**
     * 删除
     */
    private int delete;

    /**
     * 修改
     */
    private int edit;

    /**
     * 查询
     */
    private int find;

    /**
     * 排序
     */
    private int sort;

    /**
     * 资源描述
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

    public int getAdd() {
        return add;
    }

    public void setAdd(int add) {
        this.add = add;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }

    public int getFind() {
        return find;
    }

    public void setFind(int find) {
        this.find = find;
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