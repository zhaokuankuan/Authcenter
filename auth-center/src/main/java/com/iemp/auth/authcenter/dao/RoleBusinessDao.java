package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.RoleBusiness;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色业务表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:11:56
 */
public interface RoleBusinessDao {

    /**
     * 新增
     */
    public int insert(@Param("roleBusiness") RoleBusiness roleBusiness);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("roleBusiness") RoleBusiness roleBusiness);

    /**
     * Load查询
     */
    public RoleBusiness load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<RoleBusiness> getAll();


    /**
     * 分页查询Data
     */
    public List<RoleBusiness> pageList(@Param("offset") int offset,
                                       @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}
