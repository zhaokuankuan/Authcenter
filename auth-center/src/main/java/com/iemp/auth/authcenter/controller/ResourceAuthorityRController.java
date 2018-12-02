package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.ResourceAuthorityR;
import com.iemp.auth.authcenter.service.ResourceAuthorityRService;
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
 * 资源操作码关系表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 23:06:53
 */
@Api(value = "ResourceAuthorityR",tags = {"resource-authority-r-controller"},description = "资源操作码关系表")
@RestController
public class ResourceAuthorityRController {

    @Resource
    private ResourceAuthorityRService resourceAuthorityRService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/resourceAuthorityR/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insertOrUpdate(ResourceAuthorityR resourceAuthorityR){
        if(null == resourceAuthorityR){
            resourceAuthorityR = new ResourceAuthorityR();
        }
        return resourceAuthorityRService.insertOrUpdate(resourceAuthorityR);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @RequestMapping(value="/resourceAuthorityR/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(ResourceAuthorityR resourceAuthorityR){
        return resourceAuthorityRService.insert(resourceAuthorityR);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/resourceAuthorityR/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return resourceAuthorityRService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/resourceAuthorityR/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(ResourceAuthorityR resourceAuthorityR){
        return resourceAuthorityRService.update(resourceAuthorityR);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/resourceAuthorityR/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return resourceAuthorityRService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/resourceAuthorityR/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<ResourceAuthorityR> getAll(){
        return resourceAuthorityRService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/resourceAuthorityR/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return resourceAuthorityRService.pageList(offset, pagesize);
    }

}
