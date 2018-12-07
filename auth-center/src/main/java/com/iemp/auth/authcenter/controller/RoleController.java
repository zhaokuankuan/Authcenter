package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Role;
import com.iemp.auth.authcenter.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * "角色"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:08:28
 */
@Api(description = "角色的controller")
@RestController
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/role/insertOrUpdate")
    public ReturnModel insertOrUpdate(Role role){
        if(null == role){
            role = new Role();
        }
        return roleService.insertOrUpdate(role);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @PostMapping(value="/role/insert")
    public ReturnModel insert(Role role){
        return roleService.insert(role);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/role/delete")
    public ReturnModel delete(String id){
        return roleService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/role/update")
    public ReturnModel update(Role role){
        return roleService.update(role);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/role/getById")
    public ReturnModel load(String id){
        return roleService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/role/getAll")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/role/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return roleService.pageList(offset, pagesize);
    }

}
