package com.iemp.auth.authcenter.dao;

import com.iemp.auth.authcenter.domain.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作码表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:33:17
 */
public interface AuthorityDao {

    /**
     * 新增
     */
    public int insert(@Param("authority") Authority authority);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("authority") Authority authority);

    /**
     * Load查询
     */
    public Authority load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<Authority> getAll();


    /**
     * 分页查询Data
     */
    public List<Authority> pageList(@Param("offset") int offset,
                                    @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}

