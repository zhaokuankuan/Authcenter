package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.dao.AuthorityDao;
import com.iemp.auth.authcenter.domain.Authority;
import com.iemp.auth.authcenter.service.AuthorityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作码表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:33:17
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Resource
    private AuthorityDao authorityDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(Authority authority) {
        ReturnModel result = new ReturnModel();
        if (authority == null) {
            return result;
        }
        if(null != authority.getId() && !"".equals(authority.getId())){
            //修改
            result =  update(authority);
        }else{ //新增
            result = insert(authority);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(Authority authority) {
        ReturnModel result = new ReturnModel();
        if (authority == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        authorityDao.insert(authority);
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
        int ret = authorityDao.delete(id);
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
    public ReturnModel update(Authority authority) {
        ReturnModel result = new ReturnModel();
        int ret = authorityDao.update(authority);
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
        Authority authority = authorityDao.load(id);
        result.addDefaultModel("value",authority);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<Authority> getAll(){
        List<Authority> list = authorityDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<Authority> pageList = authorityDao.pageList(offset, pagesize);
        int totalCount = authorityDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}
