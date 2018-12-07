package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.common.StringUtil;
import com.iemp.auth.authcenter.domain.User;
import com.iemp.auth.authcenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户表
 * Created  by Mr.kk
 * DateTime on 2018-12-07 11:31:16
 */
@Api(description = "用户表的controller")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @PostMapping(value="/user/insertOrUpdate")
    public ReturnModel insertOrUpdate(User user){
        if(null == user){
            user = new User();
        }
        return userService.insertOrUpdate(user);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @PostMapping(value="/user/insert")
    public ReturnModel insert(User user){
        return userService.insert(user);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @PostMapping(value="/user/delete")
    public ReturnModel delete(String id){
        return userService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @PostMapping(value="/user/update")
    public ReturnModel update(User user){
        return userService.update(user);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @GetMapping(value="/user/getById")
    public ReturnModel load(String id){
        return userService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @GetMapping(value="/user/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @GetMapping(value="/user/getByPageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);
    }

    /** 根据账号查询用户的信息
     * @return
     */
    @GetMapping("/useruser/getUserByAccount")
    @ApiOperation(value = "/useruser/getUserByAccount",notes = "根据账号查询用户的信息")
    public ReturnModel getUserByAccount(String account){
        ReturnModel returnModel = new ReturnModel();
        if(StringUtil.isEmpty(account)){
            returnModel.setMsg("账号不能为空!");
            return returnModel;
        }
        User user = userService.getUserByAccount(account);
        returnModel.setSuccess(true);
        returnModel.addDefaultModel("data",user);
        return returnModel;
    }

}
