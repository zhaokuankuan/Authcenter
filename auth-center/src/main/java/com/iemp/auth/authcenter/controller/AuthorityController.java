package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Authority;
import com.iemp.auth.authcenter.service.AuthorityService;
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
 * 操作码表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:33:17
 */
@Api(value = "Authority",tags = {"authority-controller"},description = "操作码表")
@RestController
public class AuthorityController {

    @Resource
    private AuthorityService authorityService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/authority/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insertOrUpdate(Authority authority){
        if(null == authority){
            authority = new Authority();
        }
        return authorityService.insertOrUpdate(authority);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @RequestMapping(value="/authority/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(Authority authority){
        return authorityService.insert(authority);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/authority/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return authorityService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/authority/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(Authority authority){
        return authorityService.update(authority);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/authority/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return authorityService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/authority/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Authority> getAll(){
        return authorityService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/authority/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return authorityService.pageList(offset, pagesize);
    }

}

