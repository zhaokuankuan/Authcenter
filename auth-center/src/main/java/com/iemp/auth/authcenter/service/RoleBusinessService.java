package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleBusiness;

import java.util.List;
import java.util.Map;

/**
 * 角色业务表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:11:56
 */
public interface RoleBusinessService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(RoleBusiness roleBusiness);

    /**
     * 新增
     */
    public ReturnModel insert(RoleBusiness roleBusiness);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(RoleBusiness roleBusiness);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<RoleBusiness> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
