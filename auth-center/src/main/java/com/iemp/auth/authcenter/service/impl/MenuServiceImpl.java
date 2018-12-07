package com.iemp.auth.authcenter.service.impl;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.dao.MenuDao;
import com.iemp.auth.authcenter.domain.Menu;
import com.iemp.auth.authcenter.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:34:15
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(Menu menu) {
        ReturnModel result = new ReturnModel();
        if (menu == null) {
            return result;
        }
        if(null != menu.getId() && !"".equals(menu.getId())){
            //修改
            result =  update(menu);
        }else{ //新增
            result = insert(menu);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(Menu menu) {
        ReturnModel result = new ReturnModel();
        if (menu == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        menu.setId(StringUtil.createUUID());
        menuDao.insert(menu);
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
        int ret = menuDao.delete(id);
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
    public ReturnModel update(Menu menu) {
        ReturnModel result = new ReturnModel();
        int ret = menuDao.update(menu);
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
        Menu menu = menuDao.load(id);
        result.addDefaultModel("value",menu);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<Menu> getAll(){
        List<Menu> list = menuDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<Menu> pageList = menuDao.pageList(offset, pagesize);
        int totalCount = menuDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

    /**
     * 根据menIdS查询所有的menu
     */
    @Override
    public List<Menu> getMenusByMenuIds(List<String> menuIds) {
        return menuDao.getMenusByMenuIds(menuIds);
    }

}
