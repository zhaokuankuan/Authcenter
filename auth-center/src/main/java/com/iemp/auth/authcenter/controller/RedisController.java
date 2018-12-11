package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2018/12/10 14:27
 */
@RestController
@Slf4j
@Api(description = "redis的链接工具测试")
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;


    @ApiOperation(value = "insertString",notes = "存入String")
    @GetMapping("/insertString")
    public void  insertString(String str){
        log.info("存入String开始========================");
        redisUtils.insertStrng("string",str);
        log.info("存入String完成========================");
    }

    @ApiOperation(value = "getString",notes = "取出String")
    @GetMapping(value = "/getString")
    public String getString(String key){
        log.info("查询String开始========================");
        return redisUtils.getString(key).toString();
    }

    @ApiOperation(value = "inputHash",notes = "存入Hash")
    @GetMapping("/inputHash")
    public void  inputHash(String key,String o){
        log.info("存入Hash开始========================");
        redisUtils.insertHash("map",key,o,60L);
        log.info("存入Hash完成========================");
    }

    @ApiOperation(value = "getHash",notes = "取出Hash")
    @GetMapping(value = "/getHash")
    public Object getHash(String name,String key){
        log.info("查询Hash开始========================");
        return redisUtils.getHash(name,key);
    }

    @ApiOperation(value = "inputList",notes = "存入List")
    @GetMapping("/inputList")
    public void  inputList(String o){
        log.info("存入List开始========================");
        redisUtils.insertList("list",o);
        log.info("存入List完成========================");
    }

    @ApiOperation(value = "getList",notes = "取出List")
    @GetMapping(value = "/getList")
    public Object getList(String key,int startIndex,int endIndex){
        log.info("查询List========================");
        return redisUtils.getListByIndex(key,startIndex,endIndex);
    }

    @ApiOperation(value = "inputSet",notes = "存入Set")
    @GetMapping("/inputSet")
    public void  inputSet(String o){
        log.info("存入Set开始========================");
        redisUtils.insertSet("set",o);
        log.info("存入Set完成========================");
    }

    @ApiOperation(value = "getSet",notes = "取出Set")
    @GetMapping(value = "/getSet")
    public Object getSet(String key){
        log.info("查询Set========================");
        return redisUtils.getSetAll(key);
    }

    @ApiOperation(value = "inputZSet",notes = "存入ZSet")
    @GetMapping("/inputZSet")
    public void  inputZSet(String o,double score){
        log.info("存入ZSet开始========================");
        redisUtils.insertZset("zset",o,score);
        log.info("存入ZSet完成========================");
    }

    @ApiOperation(value = "getZSet",notes = "取出ZSet")
    @GetMapping(value = "/getZSet")
    public Object getZSet(String key,double b1,double b2){
        log.info("查询ZSet========================");
        return redisUtils.getZSetByIndex(key,b1,b2);
    }
}
