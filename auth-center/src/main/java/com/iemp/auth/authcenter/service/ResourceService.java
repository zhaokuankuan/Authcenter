package com.iemp.auth.authcenter.service;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Resource;

import java.util.List;
import java.util.Map;

/**
 * 资源
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:31:15
 */
public interface ResourceService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(Resource resource);

    /**
     * 新增
     */
    public ReturnModel insert(Resource resource);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(Resource resource);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<Resource> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 根据资源Id列表查询资源
     */
    public List<Resource> getResourceByIds(List<String> resoureceIds);

}
