package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 11:31:16
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

    /**
     * 根据账号查询用户信息
     */
    public User getUserByAccount(@Param("account") String account);

    /**
     * 根据账号查询用户信息
     */
    public User getUserByPhone(@Param("phone") String phone);


}
