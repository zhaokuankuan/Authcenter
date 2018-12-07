package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.RoleResourceR;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * "角色资源关系表"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:01:18
 */
public interface RoleResourceRDao {

    /**
     * 新增
     */
    public int insert(@Param("roleResourceR") RoleResourceR roleResourceR);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("roleResourceR") RoleResourceR roleResourceR);

    /**
     * Load查询
     */
    public RoleResourceR load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<RoleResourceR> getAll();


    /**
     * 分页查询Data
     */
    public List<RoleResourceR> pageList(@Param("offset") int offset,
                                        @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

    /**
     * 根据roleIds查询资源
     */
    public Set<String> getResourceByRoleIds(@Param("roleIds")List<String> roleIds);

}
