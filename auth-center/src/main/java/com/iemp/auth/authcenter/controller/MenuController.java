package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.Menu;
import com.iemp.auth.authcenter.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 菜单
 * Created  by Mr.kk
 * DateTime on 2018-12-07 13:34:15
 */
@Api(description = "菜单的controller")
@RestController
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/menu/insertOrUpdate")
    public ReturnModel insertOrUpdate(Menu menu){
        if(null == menu){
            menu = new Menu();
        }
        return menuService.insertOrUpdate(menu);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @PostMapping(value="/menu/insert")
    public ReturnModel insert(Menu menu){
        return menuService.insert(menu);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/menu/delete")
    public ReturnModel delete(String id){
        return menuService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/menu/update")
    public ReturnModel update(Menu menu){
        return menuService.update(menu);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/menu/getById")
    public ReturnModel load(String id){
        return menuService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/menu/getAll")
    public List<Menu> getAll(){
        return menuService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/menu/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return menuService.pageList(offset, pagesize);
    }

    /**
     * 根据menIdS查询所有的menu
     */
    @GetMapping("/menu/getMenusByMenuIds")
    @ApiOperation(value = "/menu/getMenusByMenuIds",notes = "根据menIdS查询所有的menu")
    public Object getMenusByMenuIds(@RequestParam("menuIds") List<String> menuIds){
        if(null==menuIds||menuIds.size()==0){
            return new ReturnModel(500,"menuIds不能为空！");
        }
        return menuService.getMenusByMenuIds(menuIds);
    }

}
