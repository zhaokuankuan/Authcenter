package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Authority;

import java.util.List;
import java.util.Map;

/**
 * 操作码表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:33:17
 */
public interface AuthorityService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(Authority authority);

    /**
     * 新增
     */
    public ReturnModel insert(Authority authority);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(Authority authority);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<Authority> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}

