package com.iemp.auth.authcenter.controller;

import com.alibaba.fastjson.JSON;
import com.iemp.auth.authcenter.common.RedisUtils;
import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.domain.Menu;
import com.iemp.auth.authcenter.domain.Resource;
import com.iemp.auth.authcenter.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthController {
    //菜单的key
    public static  final  String IEMP_USER_MENU = "IEMP_USER_MENU";
    //url的key
    public static  final  String IEMP_USER_URL = "IEMP_USER_URL";
    //redis的失效时间
    public static  final  Long REDIS_TIME_OUT = 2*60*60L ;


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
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 根据userId查询Menu
     */
    @GetMapping("/auth/getMenuByUserId")
    @ApiOperation(value = "/auth/getMenuByUserId",notes = "根据userId查询Menu")
    public Object getMenuByUserId(String userId){
        ReturnModel returnModel = new ReturnModel();
        List<Menu> menus = null;
        if(null != redisUtils.getHash(IEMP_USER_MENU,userId) && !"".equals(redisUtils.getHash(IEMP_USER_MENU,userId))){
            String redisMenu = redisUtils.getHash(IEMP_USER_MENU,userId).toString();
            menus = JSON.parseArray(redisMenu.replaceAll("\\\\",""),Menu.class);
            log.debug("从redis中获取>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }else{
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
            log.debug("从数据库中获取>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            redisUtils.insertHash("IEMP_USER_MENU",userId,JSON.toJSONString(menus),REDIS_TIME_OUT);
            log.debug(">>>>>>>>>>>>>>>>>菜单序列化："+ JSON.toJSONString(menus)+"<<<<<<<<<<<<<<<<<<<<<<");
        }
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
        if(null != redisUtils.getHash(IEMP_USER_URL,userId) && !"".equals(redisUtils.getHash(IEMP_USER_URL,userId))){
            String redisUrl = redisUtils.getHash(IEMP_USER_URL,userId).toString();
            resourceList = JSON.parseArray(redisUrl.replaceAll("\\\\",""),Resource.class);
            log.debug("从redis中获取>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }else {
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
            log.debug("从数据库中获取>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            redisUtils.insertHash("IEMP_USER_URL",userId,JSON.toJSONString(resourceList),REDIS_TIME_OUT);
            log.debug(">>>>>>>>>>>>>>>>>资源序列化："+ JSON.toJSONString(resourceList)+"<<<<<<<<<<<<<<<<<<<<<<");
        }
        returnModel.setData(resourceList);
        returnModel.setSuccess(true);
        returnModel.setMsg("查询资源列表成功！");
        return returnModel;
    }

}
