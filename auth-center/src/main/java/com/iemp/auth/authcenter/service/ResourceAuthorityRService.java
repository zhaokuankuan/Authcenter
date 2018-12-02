package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.ResourceAuthorityR;

import java.util.List;
import java.util.Map;

/**
 * 资源操作码关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:06:53
 */
public interface ResourceAuthorityRService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(ResourceAuthorityR resourceAuthorityR);

    /**
     * 新增
     */
    public ReturnModel insert(ResourceAuthorityR resourceAuthorityR);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(ResourceAuthorityR resourceAuthorityR);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<ResourceAuthorityR> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
