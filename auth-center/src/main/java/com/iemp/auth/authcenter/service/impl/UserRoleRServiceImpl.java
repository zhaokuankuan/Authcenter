package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.dao.UserRoleRDao;
import com.iemp.auth.authcenter.domain.UserRoleR;
import com.iemp.auth.authcenter.service.UserRoleRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户角色关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:36:53
 */
@Service
public class UserRoleRServiceImpl implements UserRoleRService {

    @Resource
    private UserRoleRDao userRoleRDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(UserRoleR userRoleR) {
        ReturnModel result = new ReturnModel();
        if (userRoleR == null) {
            return result;
        }
        if(null != userRoleR.getId() && !"".equals(userRoleR.getId())){
            //修改
            result =  update(userRoleR);
        }else{ //新增
            result = insert(userRoleR);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(UserRoleR userRoleR) {
        ReturnModel result = new ReturnModel();
        if (userRoleR == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        userRoleR.setId(StringUtil.createUUID());
        userRoleRDao.insert(userRoleR);
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
        int ret = userRoleRDao.delete(id);
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
    public ReturnModel update(UserRoleR userRoleR) {
        ReturnModel result = new ReturnModel();
        int ret = userRoleRDao.update(userRoleR);
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
        UserRoleR userRoleR = userRoleRDao.load(id);
        result.addDefaultModel("value",userRoleR);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<UserRoleR> getAll(){
        List<UserRoleR> list = userRoleRDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<UserRoleR> pageList = userRoleRDao.pageList(offset, pagesize);
        int totalCount = userRoleRDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

    /**
     * 根据UserId查询用户所有的roles
     */
    @Override
    public Set<String> getRoleIdsByUserId(String userId) {
        Set<String> set = new HashSet<String>();
        if(StringUtil.isNotEmpty(userId)){
            set = userRoleRDao.getRoleIdsByUserId(userId);
        }
        return set;
    }

}
