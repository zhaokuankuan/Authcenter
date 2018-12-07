package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleMenuR;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 角色菜单关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:39:07
 */
public interface RoleMenuRService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(RoleMenuR roleMenuR);

    /**
     * 新增
     */
    public ReturnModel insert(RoleMenuR roleMenuR);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(RoleMenuR roleMenuR);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<RoleMenuR> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 根据roles查询菜单
     */
    public Set<String> getMenuIdsByRoleIds(List<String> reolIds);

}
