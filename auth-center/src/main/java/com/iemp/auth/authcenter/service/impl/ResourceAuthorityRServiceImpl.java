package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.dao.ResourceAuthorityRDao;
import com.iemp.auth.authcenter.domain.ResourceAuthorityR;
import com.iemp.auth.authcenter.service.ResourceAuthorityRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源操作码关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:06:53
 */
@Service
public class ResourceAuthorityRServiceImpl implements ResourceAuthorityRService {

    @Resource
    private ResourceAuthorityRDao resourceAuthorityRDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(ResourceAuthorityR resourceAuthorityR) {
        ReturnModel result = new ReturnModel();
        if (resourceAuthorityR == null) {
            return result;
        }
        if(null != resourceAuthorityR.getId() && !"".equals(resourceAuthorityR.getId())){
            //修改
            result =  update(resourceAuthorityR);
        }else{ //新增
            result = insert(resourceAuthorityR);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(ResourceAuthorityR resourceAuthorityR) {
        ReturnModel result = new ReturnModel();
        if (resourceAuthorityR == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        resourceAuthorityRDao.insert(resourceAuthorityR);
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
        int ret = resourceAuthorityRDao.delete(id);
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
    public ReturnModel update(ResourceAuthorityR resourceAuthorityR) {
        ReturnModel result = new ReturnModel();
        int ret = resourceAuthorityRDao.update(resourceAuthorityR);
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
        ResourceAuthorityR resourceAuthorityR = resourceAuthorityRDao.load(id);
        result.addDefaultModel("value",resourceAuthorityR);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<ResourceAuthorityR> getAll(){
        List<ResourceAuthorityR> list = resourceAuthorityRDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<ResourceAuthorityR> pageList = resourceAuthorityRDao.pageList(offset, pagesize);
        int totalCount = resourceAuthorityRDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}
