package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.UserRoleR;

import java.util.List;
import java.util.Map;

/**
 * 角色用户关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:40:49
 */
public interface UserRoleRService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(UserRoleR userRoleR);

    /**
     * 新增
     */
    public ReturnModel insert(UserRoleR userRoleR);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(UserRoleR userRoleR);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<UserRoleR> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
