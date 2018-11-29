package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * "角色"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:08:28
 */
public interface RoleDao {

    /**
     * 新增
     */
    public int insert(@Param("role") Role role);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("role") Role role);

    /**
     * Load查询
     */
    public Role load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<Role> getAll();


    /**
     * 分页查询Data
     */
    public List<Role> pageList(@Param("offset") int offset,
                               @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}
