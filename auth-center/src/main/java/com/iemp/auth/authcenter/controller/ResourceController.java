package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Resource;
import com.iemp.auth.authcenter.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 资源
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:31:15
 */
@Api(description = "资源的controller")
@RestController
public class ResourceController {

    @Autowired
    private ResourceService ResourceService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/Resource/insertOrUpdate")
    public ReturnModel insertOrUpdate(Resource resource){
        if(null == resource){
            resource = new Resource();
        }
        return ResourceService.insertOrUpdate(resource);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @PostMapping(value="/Resource/insert")
    public ReturnModel insert(Resource resource){
        return ResourceService.insert(resource);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/Resource/delete")
    public ReturnModel delete(String id){
        return ResourceService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/Resource/update")
    public ReturnModel update(Resource resource){
        return ResourceService.update(resource);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/Resource/getById")
    public ReturnModel load(String id){
        return ResourceService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/Resource/getAll")
    public List<Resource> getAll(){
        return ResourceService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/Resource/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return ResourceService.pageList(offset, pagesize);
    }

    /**
     * 根据资源Id列表查询资源
     */
    @GetMapping("/Resource/getResourceByIds")
    @ApiOperation(value ="/Resource/getResourceByIds",notes = "根据资源Id列表查询资源")
    public Object getResourceByIds(@RequestParam("resoureceIds") List<String> resoureceIds){
        if(null==resoureceIds||resoureceIds.size()==0){
            return new ReturnModel(500,"resoureceIds不能为空!");
        }
        return ResourceService.getResourceByIds(resoureceIds);
    }

}
