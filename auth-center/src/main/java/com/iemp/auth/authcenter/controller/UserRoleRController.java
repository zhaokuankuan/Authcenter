package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.UserRoleR;
import com.iemp.auth.authcenter.service.UserRoleRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 角色用户关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:40:49
 */
@Api(value = "UserRoleR",tags = {"user-role-R-controller"},description = "角色用户关系表")
@RestController
public class UserRoleRController {

    @Resource
    private UserRoleRService userRoleRService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/userRoleR/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insertOrUpdate(UserRoleR userRoleR){
        if(null == userRoleR){
            userRoleR = new UserRoleR();
        }
        return userRoleRService.insertOrUpdate(userRoleR);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @RequestMapping(value="/userRoleR/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(UserRoleR userRoleR){
        return userRoleRService.insert(userRoleR);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/userRoleR/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return userRoleRService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/userRoleR/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(UserRoleR userRoleR){
        return userRoleRService.update(userRoleR);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/userRoleR/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return userRoleRService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/userRoleR/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<UserRoleR> getAll(){
        return userRoleRService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/userRoleR/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userRoleRService.pageList(offset, pagesize);
    }

}
