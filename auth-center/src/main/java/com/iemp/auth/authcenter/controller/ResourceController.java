package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Resource;
import com.iemp.auth.authcenter.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 资源表
 * Created  by Mr.kk
 * DateTime on 2018-11-29 22:22:33
 */
@Api(value = "Resource",tags = {"resource-controller"},description = "资源表")
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/resource/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insertOrUpdate(Resource resource){
        if(null == resource){
            resource = new Resource();
        }
        return resourceService.insertOrUpdate(resource);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @RequestMapping(value="/resource/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(Resource resource){
        return resourceService.insert(resource);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/resource/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return resourceService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/resource/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(Resource resource){
        return resourceService.update(resource);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/resource/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return resourceService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/resource/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Resource> getAll(){
        return resourceService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/resource/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return resourceService.pageList(offset, pagesize);
    }

}

