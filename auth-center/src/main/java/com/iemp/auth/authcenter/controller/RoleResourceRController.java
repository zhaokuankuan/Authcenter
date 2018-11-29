package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleResourceR;
import com.iemp.auth.authcenter.service.RoleResourceRService;
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
 * "角色资源关系表"
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:01:18
 */
@Api(value = "RoleResourceR",tags = {"role-resource-r-controller"},description = "角色资源关系表")
@RestController
public class RoleResourceRController {

    @Resource
    private RoleResourceRService roleResourceRService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/roleResourceR/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
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
    @RequestMapping(value="/roleResourceR/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(RoleResourceR roleResourceR){
        return roleResourceRService.insert(roleResourceR);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/roleResourceR/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return roleResourceRService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/roleResourceR/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(RoleResourceR roleResourceR){
        return roleResourceRService.update(roleResourceR);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/roleResourceR/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return roleResourceRService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/roleResourceR/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<RoleResourceR> getAll(){
        return roleResourceRService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/roleResourceR/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return roleResourceRService.pageList(offset, pagesize);
    }

}
