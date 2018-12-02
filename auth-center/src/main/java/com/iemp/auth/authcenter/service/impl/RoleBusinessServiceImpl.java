package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.dao.RoleBusinessDao;
import com.iemp.auth.authcenter.domain.RoleBusiness;
import com.iemp.auth.authcenter.service.RoleBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色业务表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:11:56
 */
@Service
public class RoleBusinessServiceImpl implements RoleBusinessService {

    @Resource
    private RoleBusinessDao roleBusinessDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(RoleBusiness roleBusiness) {
        ReturnModel result = new ReturnModel();
        if (roleBusiness == null) {
            return result;
        }
        if(null != roleBusiness.getId() && !"".equals(roleBusiness.getId())){
            //修改
            result =  update(roleBusiness);
        }else{ //新增
            result = insert(roleBusiness);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(RoleBusiness roleBusiness) {
        ReturnModel result = new ReturnModel();
        if (roleBusiness == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        roleBusinessDao.insert(roleBusiness);
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
        int ret = roleBusinessDao.delete(id);
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
    public ReturnModel update(RoleBusiness roleBusiness) {
        ReturnModel result = new ReturnModel();
        int ret = roleBusinessDao.update(roleBusiness);
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
        RoleBusiness roleBusiness = roleBusinessDao.load(id);
        result.addDefaultModel("value",roleBusiness);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<RoleBusiness> getAll(){
        List<RoleBusiness> list = roleBusinessDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<RoleBusiness> pageList = roleBusinessDao.pageList(offset, pagesize);
        int totalCount = roleBusinessDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}
