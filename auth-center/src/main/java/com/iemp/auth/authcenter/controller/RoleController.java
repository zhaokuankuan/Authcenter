package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Role;
import com.iemp.auth.authcenter.service.RoleService;
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
 * "角色"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:08:28
 */
@Api(value = "Role",tags = {"role-controller"},description = "角色")
@RestController
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/role/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
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
    @RequestMapping(value="/role/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(Role role){
        return roleService.insert(role);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/role/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return roleService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/role/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(Role role){
        return roleService.update(role);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/role/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return roleService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/role/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Role> getAll(){
        return roleService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/role/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return roleService.pageList(offset, pagesize);
    }

}
