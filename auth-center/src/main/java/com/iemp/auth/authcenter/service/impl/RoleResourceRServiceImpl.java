package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.dao.RoleResourceRDao;
import com.iemp.auth.authcenter.domain.RoleResourceR;
import com.iemp.auth.authcenter.service.RoleResourceRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * "角色资源关系表"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:01:18
 */
@Service
public class RoleResourceRServiceImpl implements RoleResourceRService {

    @Resource
    private RoleResourceRDao roleResourceRDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(RoleResourceR roleResourceR) {
        ReturnModel result = new ReturnModel();
        if (roleResourceR == null) {
            return result;
        }
        if(null != roleResourceR.getId() && !"".equals(roleResourceR.getId())){
            //修改
            result =  update(roleResourceR);
        }else{ //新增
            result = insert(roleResourceR);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(RoleResourceR roleResourceR) {
        ReturnModel result = new ReturnModel();
        if (roleResourceR == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        roleResourceR.setId(StringUtil.createUUID());
        roleResourceRDao.insert(roleResourceR);
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
        int ret = roleResourceRDao.delete(id);
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
    public ReturnModel update(RoleResourceR roleResourceR) {
        ReturnModel result = new ReturnModel();
        int ret = roleResourceRDao.update(roleResourceR);
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
        RoleResourceR roleResourceR = roleResourceRDao.load(id);
        result.addDefaultModel("value",roleResourceR);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<RoleResourceR> getAll(){
        List<RoleResourceR> list = roleResourceRDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<RoleResourceR> pageList = roleResourceRDao.pageList(offset, pagesize);
        int totalCount = roleResourceRDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

    /**
     * 根据roleIds查询资源
     */
    @Override
    public Set<String> getResourceByRoleIds(List<String> roleIds) {
        return roleResourceRDao.getResourceByRoleIds(roleIds);
    }

}
