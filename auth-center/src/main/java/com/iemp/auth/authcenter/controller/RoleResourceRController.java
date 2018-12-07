package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleResourceR;
import com.iemp.auth.authcenter.service.RoleResourceRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * "角色资源关系表"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:01:18
 */
@Api(description = "角色资源关系表")
@RestController
public class RoleResourceRController {

    @Resource
    private RoleResourceRService roleResourceRService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/roleResourceR/insertOrUpdate")
    public ReturnModel insertOrUpdate(RoleResourceR roleResourceR){
        if(null == roleResourceR){
            roleResourceR = new RoleResourceR();
        }
        return roleResourceRService.insertOrUpdate(roleResourceR);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @PostMapping(value="/roleResourceR/insert")
    public ReturnModel insert(RoleResourceR roleResourceR){
        return roleResourceRService.insert(roleResourceR);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/roleResourceR/delete")
    public ReturnModel delete(String id){
        return roleResourceRService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/roleResourceR/update")
    public ReturnModel update(RoleResourceR roleResourceR){
        return roleResourceRService.update(roleResourceR);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/roleResourceR/getById")
    public ReturnModel load(String id){
        return roleResourceRService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/roleResourceR/getAll")
    public List<RoleResourceR> getAll(){
        return roleResourceRService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/getResourceByRoleIds/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return roleResourceRService.pageList(offset, pagesize);
    }


    @GetMapping("/getResourceByRoleIds/getResourceByRoleIds")
    public Object getResourceByRoleIds(@RequestParam(value = "roleIds") List<String> roleIds){
        if(null == roleIds || roleIds.size() == 0){
            return new ReturnModel(500,"roleIds不能为空!");
        }
        return  roleResourceRService.getResourceByRoleIds(roleIds);
    }

}
