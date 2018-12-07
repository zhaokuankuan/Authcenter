package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:34:15
 */
public interface MenuService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(Menu menu);

    /**
     * 新增
     */
    public ReturnModel insert(Menu menu);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(Menu menu);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<Menu> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 根据menIdS查询所有的menu
     */
    public List<Menu> getMenusByMenuIds(List<String> menuIds);

}
