package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.RoleMenuR;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 角色菜单关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:39:07
 */
public interface RoleMenuRDao {

    /**
     * 新增
     */
    public int insert(@Param("roleMenuR") RoleMenuR roleMenuR);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("roleMenuR") RoleMenuR roleMenuR);

    /**
     * Load查询
     */
    public RoleMenuR load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<RoleMenuR> getAll();


    /**
     * 分页查询Data
     */
    public List<RoleMenuR> pageList(@Param("offset") int offset,
                                    @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

    /**
     * 根据roles查询菜单
     */
    public Set<String> getMenuIdsByRoleIds(@Param("roleIds") List<String> roleIds);

}
