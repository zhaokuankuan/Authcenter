package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.UserRoleR;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户角色关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:36:53
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

    /**
     * 根据userId查询该用户拥有的角色
     */
    public Set<String> getRoleIdsByUserId(@Param("userId") String userId);

}
