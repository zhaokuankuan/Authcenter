package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleResourceR;

import java.util.List;
import java.util.Map;

/**
 * "角色资源关系表"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:01:18
 */
public interface RoleResourceRService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(RoleResourceR roleResourceR);

    /**
     * 新增
     */
    public ReturnModel insert(RoleResourceR roleResourceR);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(RoleResourceR roleResourceR);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<RoleResourceR> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
