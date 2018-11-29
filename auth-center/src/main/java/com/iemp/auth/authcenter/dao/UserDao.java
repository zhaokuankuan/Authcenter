package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :Mr.kk
 * @date: 2018/11/29 18:57
 */
public interface UserDao {

    /**
     * 新增
     */
    public int insert(@Param("user") User user);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("user") User user);

    /**
     * Load查询
     */
    public User load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<User> getAll();


    /**
     * 分页查询Data
     */
    public List<User> pageList(@Param("offset") int offset,
                               @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);
}
