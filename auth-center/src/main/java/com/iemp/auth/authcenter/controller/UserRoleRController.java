package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.domain.UserRoleR;
import com.iemp.auth.authcenter.service.UserRoleRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户角色关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:36:53
 */
@Api(description = "用户角色关系表的controller")
@RestController
public class UserRoleRController {

    @Resource
    private UserRoleRService userRoleRService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/userRoleR/insertOrUpdate")
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
    @PostMapping(value="/userRoleR/insert")
    public ReturnModel insert(UserRoleR userRoleR){
        return userRoleRService.insert(userRoleR);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/userRoleR/delete")
    public ReturnModel delete(String id){
        return userRoleRService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/userRoleR/update")
    public ReturnModel update(UserRoleR userRoleR){
        return userRoleRService.update(userRoleR);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/userRoleR/getById")
    public ReturnModel load(String id){
        return userRoleRService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/userRoleR/getAll")
    public List<UserRoleR> getAll(){
        return userRoleRService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/userRoleR/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userRoleRService.pageList(offset, pagesize);
    }


    /**
     * 根据userId查询用户拥有的所有的Roles
     */
    @GetMapping("/getRoleIdsByUserId")
    @ApiOperation(value = "/userRoleR/getRoleIdsByUserId",notes = "根据userId查询用户拥有的所有的Roles")
    public Object getRoleIdsByUserId(String userId){
        if(StringUtil.isEmpty(userId)){
            return new ReturnModel(500,"userId不能为空！");
        }
        return userRoleRService.getRoleIdsByUserId(userId);
    }

}
