package com.iemp.auth.authcenter.dao;


import com.iemp.auth.authcenter.domain.UserRoleR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色用户关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:40:49
 */
public interface UserRoleRDao {

    /**
     * 新增
     */
    public int insert(@Param("userRoleR") UserRoleR userRoleR);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("userRoleR") UserRoleR userRoleR);

    /**
     * Load查询
     */
    public UserRoleR load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<UserRoleR> getAll();


    /**
     * 分页查询Data
     */
    public List<UserRoleR> pageList(@Param("offset") int offset,
                                    @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}

