package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:22:33
 */
public interface ResourceDao {

    /**
     * 新增
     */
    public int insert(@Param("resource") Resource resource);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("resource") Resource resource);

    /**
     * Load查询
     */
    public Resource load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<Resource> getAll();


    /**
     * 分页查询Data
     */
    public List<Resource> pageList(@Param("offset") int offset,
                                   @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}
