package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.dao.ResourceDao;
import com.iemp.auth.authcenter.domain.Resource;
import com.iemp.auth.authcenter.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:31:15
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private ResourceDao ResourceDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(Resource resource) {
        ReturnModel result = new ReturnModel();
        if (resource == null) {
            return result;
        }
        if(null != resource.getId() && !"".equals(resource.getId())){
            //修改
            result =  update(resource);
        }else{ //新增
            result = insert(resource);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(Resource resource) {
        ReturnModel result = new ReturnModel();
        if (resource == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        resource.setId(StringUtil.createUUID());
        ResourceDao.insert(resource);
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除
     */
    @Override
    public ReturnModel delete(String id) {
        ReturnModel result = new ReturnModel();
        if(null == id || "".equals(id)){
            result.setMsg("id不能为空！");
            return result;
        }
        int ret = ResourceDao.delete(id);
        if(ret > 0){
            result.setSuccess(true);
            return  result;
        }else{
            return  result;
        }
    }

    /**
     * 修改
     */
    @Override
    public ReturnModel update(Resource resource) {
        ReturnModel result = new ReturnModel();
        int ret = ResourceDao.update(resource);
        if(ret > 0){
            result.setSuccess(true);
            return  result;
        }else{
            return  result;
        }
    }

    /**
     * 根据Id查询
     */
    @Override
    public ReturnModel load(String id) {
        ReturnModel result = new ReturnModel();
        if(null == id || "".equals(id)){
            result.setMsg("id不能为空！");
            return result;
        }
        Resource Resource = ResourceDao.load(id);
        result.addDefaultModel("value",Resource);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<Resource> getAll(){
        List<Resource> list = ResourceDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<Resource> pageList = ResourceDao.pageList(offset, pagesize);
        int totalCount = ResourceDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

    /**
     * 根据资源Id列表查询资源
     */
    @Override
    public List<Resource> getResourceByIds(List<String> resoureceIds) {
        return ResourceDao.getResourceByIds(resoureceIds);
    }

}
