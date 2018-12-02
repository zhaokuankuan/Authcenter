package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.ResourceAuthorityR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源操作码关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:06:53
 */
public interface ResourceAuthorityRDao {

    /**
     * 新增
     */
    public int insert(@Param("resourceAuthorityR") ResourceAuthorityR resourceAuthorityR);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("resourceAuthorityR") ResourceAuthorityR resourceAuthorityR);

    /**
     * Load查询
     */
    public ResourceAuthorityR load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<ResourceAuthorityR> getAll();


    /**
     * 分页查询Data
     */
    public List<ResourceAuthorityR> pageList(@Param("offset") int offset,
                                             @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}
