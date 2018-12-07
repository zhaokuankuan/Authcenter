package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.dao.RoleDao;
import com.iemp.auth.authcenter.domain.Role;
import com.iemp.auth.authcenter.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * "角色"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:08:28
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(Role role) {
        ReturnModel result = new ReturnModel();
        if (role == null) {
            return result;
        }
        if(null != role.getId() && !"".equals(role.getId())){
            //修改
            result =  update(role);
        }else{ //新增
            result = insert(role);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(Role role) {
        ReturnModel result = new ReturnModel();
        if (role == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        role.setId(StringUtil.createUUID());
        roleDao.insert(role);
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
        int ret = roleDao.delete(id);
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
    public ReturnModel update(Role role) {
        ReturnModel result = new ReturnModel();
        int ret = roleDao.update(role);
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
        Role role = roleDao.load(id);
        result.addDefaultModel("value",role);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<Role> getAll(){
        List<Role> list = roleDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<Role> pageList = roleDao.pageList(offset, pagesize);
        int totalCount = roleDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}

