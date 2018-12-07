package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.UserRoleR;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户角色关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:36:53
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

    /**
     * 根据UserId查询用户所有的roles
     */
    public Set<String> getRoleIdsByUserId(String userId);

}
