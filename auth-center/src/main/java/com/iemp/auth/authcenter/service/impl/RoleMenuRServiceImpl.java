package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.dao.RoleMenuRDao;
import com.iemp.auth.authcenter.domain.RoleMenuR;
import com.iemp.auth.authcenter.service.RoleMenuRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 角色菜单关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:39:07
 */
@Service
public class RoleMenuRServiceImpl implements RoleMenuRService {

    @Resource
    private RoleMenuRDao roleMenuRDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(RoleMenuR roleMenuR) {
        ReturnModel result = new ReturnModel();
        if (roleMenuR == null) {
            return result;
        }
        if(null != roleMenuR.getId() && !"".equals(roleMenuR.getId())){
            //修改
            result =  update(roleMenuR);
        }else{ //新增
            result = insert(roleMenuR);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(RoleMenuR roleMenuR) {
        ReturnModel result = new ReturnModel();
        if (roleMenuR == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        roleMenuR.setId(StringUtil.createUUID());
        roleMenuRDao.insert(roleMenuR);
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
        int ret = roleMenuRDao.delete(id);
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
    public ReturnModel update(RoleMenuR roleMenuR) {
        ReturnModel result = new ReturnModel();
        int ret = roleMenuRDao.update(roleMenuR);
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
        RoleMenuR roleMenuR = roleMenuRDao.load(id);
        result.addDefaultModel("value",roleMenuR);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<RoleMenuR> getAll(){
        List<RoleMenuR> list = roleMenuRDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<RoleMenuR> pageList = roleMenuRDao.pageList(offset, pagesize);
        int totalCount = roleMenuRDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

    /**
     * 根据roles查询菜单
     */
    @Override
    public Set<String> getMenuIdsByRoleIds(List<String> reolIds) {
        Set<String> set = new HashSet<String>();
        if(null!=reolIds&&reolIds.size()>0){
            set = roleMenuRDao.getMenuIdsByRoleIds(reolIds);
        }
        return set;
    }

}
