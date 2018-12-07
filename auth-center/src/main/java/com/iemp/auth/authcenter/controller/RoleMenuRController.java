package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleMenuR;
import com.iemp.auth.authcenter.service.RoleMenuRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 角色菜单关系表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:39:07
 */
@Api(description =  "角色菜单关系表")
@RestController
public class RoleMenuRController {

    @Resource
    private RoleMenuRService roleMenuRService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/roleMenuR/insertOrUpdate")
    public ReturnModel insertOrUpdate(RoleMenuR roleMenuR){
        if(null == roleMenuR){
            roleMenuR = new RoleMenuR();
        }
        return roleMenuRService.insertOrUpdate(roleMenuR);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @PostMapping(value="/roleMenuR/insert")
    public ReturnModel insert(RoleMenuR roleMenuR){
        return roleMenuRService.insert(roleMenuR);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/roleMenuR/delete")
    public ReturnModel delete(String id){
        return roleMenuRService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/roleMenuR/update")
    public ReturnModel update(RoleMenuR roleMenuR){
        return roleMenuRService.update(roleMenuR);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/roleMenuR/getById")
    public ReturnModel load(String id){
        return roleMenuRService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/roleMenuR/getAll")
    public List<RoleMenuR> getAll(){
        return roleMenuRService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/roleMenuR/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return roleMenuRService.pageList(offset, pagesize);
    }

    /**
     * 根据roleIds查询menuIds
     */
    @GetMapping("/getMenuIdsByRoleIds")
    @ApiOperation(value = "/getMenuIdsByRoleIds",notes = "根据roleIds查询menuIds")
    public Object getMenuIdsByRoleIds(@RequestParam("roles") List<String> roles){
        if(null==roles||roles.size()==0){
            return new ReturnModel(500,"roles不能为空!");
        }
        return roleMenuRService.getMenuIdsByRoleIds(roles);
    }
}
