package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:34:15
 */
public interface MenuDao {

    /**
     * 新增
     */
    public int insert(@Param("menu") Menu menu);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("menu") Menu menu);

    /**
     * Load查询
     */
    public Menu load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<Menu> getAll();


    /**
     * 分页查询Data
     */
    public List<Menu> pageList(@Param("offset") int offset,
                               @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

    /**
     * 根据menuIds查询菜单
     */
    public List<Menu> getMenusByMenuIds(@Param("menuIds") List<String> menuIds);

}
