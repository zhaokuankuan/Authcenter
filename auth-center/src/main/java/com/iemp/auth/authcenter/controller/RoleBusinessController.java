package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.RoleBusiness;
import com.iemp.auth.authcenter.service.RoleBusinessService;
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
 * 角色业务表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:11:56
 */
@Api(value = "RoleBusiness",tags = {"role-business-controller"},description = "角色业务表")
@RestController
public class RoleBusinessController {

    @Resource
    private RoleBusinessService roleBusinessService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/roleBusiness/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insertOrUpdate(RoleBusiness roleBusiness){
        if(null == roleBusiness){
            roleBusiness = new RoleBusiness();
        }
        return roleBusinessService.insertOrUpdate(roleBusiness);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @RequestMapping(value="/roleBusiness/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(RoleBusiness roleBusiness){
        return roleBusinessService.insert(roleBusiness);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/roleBusiness/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return roleBusinessService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/roleBusiness/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(RoleBusiness roleBusiness){
        return roleBusinessService.update(roleBusiness);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/roleBusiness/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return roleBusinessService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/roleBusiness/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<RoleBusiness> getAll(){
        return roleBusinessService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/roleBusiness/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return roleBusinessService.pageList(offset, pagesize);
    }

}
