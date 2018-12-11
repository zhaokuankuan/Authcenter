package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 11:31:16
 */
public interface UserService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(User user);

    /**
     * 新增
     */
    public ReturnModel insert(User user);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(User user);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<User> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 根据账号查询用户信息
     */
    public User getUserByAccount(String account);

    /**
     * 根据电话查询用户信息
     */
    public User getUserByPhone(String phone);


}
