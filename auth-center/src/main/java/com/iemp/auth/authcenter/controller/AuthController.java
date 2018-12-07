package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.domain.Menu;
import com.iemp.auth.authcenter.domain.Resource;
import com.iemp.auth.authcenter.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *  权限的接口入口
 * @author :Mr.kk
 * @date: 2018/12/7 13:59
 */
@Api(description = "权限接口controller")
@RestController
public class AuthController {

    @Autowired
    private UserRoleRService userRoleRService;
    @Autowired
    private RoleMenuRService roleMenuRService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleResourceRService roleResourceRService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 根据userId查询Menu
     */
    @GetMapping("/auth/getMenuByUserId")
    @ApiOperation(value = "/auth/getMenuByUserId",notes = "根据userId查询Menu")
    public Object getMenuByUserId(String userId){
        ReturnModel returnModel = new ReturnModel();
        List<Menu> menus = null;
        if(StringUtil.isEmpty(userId)){
            returnModel.setMsg("userId不能为空");
            return returnModel;
        }
        Set<String> roleIds = userRoleRService.getRoleIdsByUserId(userId);
        if(null == roleIds||roleIds.size()==0){
            returnModel.setMsg("该用户未分配角色");
            return returnModel;
        }
        Set<String> menuIds = roleMenuRService.getMenuIdsByRoleIds(new ArrayList<>(roleIds));
        if(null == menuIds || menuIds.size() == 0){
            returnModel.setMsg("该用户未分配菜单");
            return returnModel;
        }
        menus = menuService.getMenusByMenuIds(new ArrayList<>(menuIds));
        returnModel.setMsg("查询菜单资源成功!");
        returnModel.setSuccess(true);
        returnModel.setData(menus);
        return returnModel;
    }

    /**
     *  根据userId查询资源
     */
    @ApiOperation(value = "/auth/getResoureByUserId",notes = "根据userId查询资源")
    @GetMapping("/auth/getResoureByUserId")
    public Object getResoureByUserId(String userId){
        ReturnModel returnModel = new ReturnModel();
        List<Resource> resourceList = null;
        if(StringUtil.isEmpty(userId)){
            returnModel.setMsg("userId不能为空");
            return returnModel;
        }
        Set<String> roleIds = userRoleRService.getRoleIdsByUserId(userId);
        if(null == roleIds||roleIds.size()==0){
            returnModel.setMsg("该用户未分配角色");
            return returnModel;
        }
        Set<String> resourceByRoleIds = roleResourceRService.getResourceByRoleIds(new ArrayList<>(roleIds));
        if(null == resourceByRoleIds || resourceByRoleIds.size() == 0){
            returnModel.setMsg("该用户未分配资源");
            return returnModel;
        }
        resourceList = resourceService.getResourceByIds(new ArrayList<>(resourceByRoleIds));
        returnModel.setData(resourceList);
        returnModel.setSuccess(true);
        returnModel.setMsg("查询资源列表成功！");
        return returnModel;
    }


}
