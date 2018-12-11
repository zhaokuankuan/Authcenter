package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.*;
import com.iemp.auth.authcenter.domain.User;
import com.iemp.auth.authcenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :Mr.kk
 * @date: 2018/11/30 13:27
 */
@RestController
@Slf4j
@Api(description = "登录/登出接口")
public class LoginController{

    //手机验证码
    private static int TYPE_PHONE_CODE = 1;
    //用户账号密码
    private static int TYPE_USER_PASSWORD = 2;
    //用户
    private static final String LOGIN_USER = "LOGIN_USER";

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;


    /** 登陆
     * @param user
     * @return
     */
    @PostMapping(value="/login")
    @ResponseBody
    @ApiOperation(value = "/login",notes = "登陆")
    public ReturnModel userLogin(@RequestParam(value = "user", required = true) String user,
                                 @RequestParam(value = "key", required = true) String key,
                                 @RequestParam(value = "type", required = true) Integer type){
        ReturnModel returnModel = new ReturnModel();
        try {
            if(StringUtil.isEmpty(user) || StringUtil.isEmpty(key) || StringUtil.isEmpty(type)){
                returnModel.setMsg("参数不合法请重新输入！");
                return returnModel;
            }
            User loginUser = null;
            //手机号登录
            if(TYPE_USER_PASSWORD == type){
                loginUser = userService.getUserByAccount(user);
                //账号密码登录
            }else if(TYPE_PHONE_CODE == type){
                loginUser =  userService.getUserByPhone(user);
            }else {
                returnModel.setMsg("参数不合法请重新输入！");
                return returnModel;
            }
            if(null == loginUser || !MD5Util.MD5(key).equals(loginUser.getPassword())){
                returnModel.setMsg("账号或者密码错误！");
                return returnModel;
            }
            //生成token
            String token = JwtToken.createToken(loginUser);
            log.debug("token :"+token);
            //将用户登录信息存入redis
            redisUtils.insertHashNotime(LOGIN_USER,loginUser.getId(),loginUser);
            log.debug(">>>>>>token存入redis成功<<<<<<<<<<<<<<<<<");
            returnModel.addDefaultModel("token",token);
            returnModel.setMsg("登录成功！");
            returnModel.setSuccess(true);
        }catch (Exception e){
            returnModel.setSuccess(false);
            returnModel.setMsg("登录失败！");
            e.printStackTrace();
        }
        return returnModel;
    }

    /**
     * 注册
     */
    @ApiOperation(value = "/signUp",notes = "注册")
    @PostMapping("/signUp")
    public ReturnModel signUp(@RequestParam(value = "phone", required = true) String phone,
                              @RequestParam(value = "password", required = true) String password,
                              @RequestParam(value = "code", required = true) String code) {
        ReturnModel returnModel = new ReturnModel();
        if(StringUtil.isEmpty(phone) || StringUtil.isEmpty(password) || StringUtil.isEmpty(code)
                // TODO: 2018/12/10  正式使用时候放开，进行手机验证码的验证
                //|| !checkCode(code,phone)
                ){
            returnModel.setMsg("数据不合法!");
            return returnModel;
        }
        try {
            User user = null;
            user = userService.getUserByPhone(phone);
            if(user!=null&&StringUtil.isNotEmpty(user.getId())){
                returnModel.setMsg("该手机号已经注册!");
                return  returnModel;
            }
            user = new User();
            user.setId(StringUtil.createUUID());
            user.setPhone(phone);
            user.setLoginName(phone);
            user.setPassword(MD5Util.MD5(password));
            user.setCreateTime(DateUtils.getTs());
            userService.insert(user);
            returnModel.setSuccess(true);
            returnModel.setMsg("注册成功!");
            log.debug(">>>>>>>>>>>>>>>>>>>注册成功！<<<<<<<<<<<<<<<<<<<<<");
        }catch (Exception e){
            returnModel.setSuccess(false);
            log.debug(">>>>>>>>>>>>>>>>>>>注册失败！<<<<<<<<<<<<<<<<<<<<<");
            e.printStackTrace();
        }
        return returnModel;
    }

    /**
     * check手机验证码
     * @param code
     * @param phone
     * @return
     */
    public boolean checkCode(String code,String phone){
        if(StringUtil.isEmpty(code)){
            return false;
        }
        Object _code = redisUtils.getString("code_" + phone);
        if (_code != null && code.equals(_code))
            return true;
        return false;
    }

    /**
     * 退出
     * @param userId
     * @return ReturnModel
     */
    @PostMapping(value="/logout")
    @ApiOperation(value = "/logout",notes = "退出")
    public ReturnModel logout(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(value = "userId",required = true) String userId) throws Exception{
        ReturnModel returnModel = new ReturnModel();
        try {
            Object obj = (User) redisUtils.getHash(LOGIN_USER,userId);
            if (StringUtil.isEmpty(obj)) {
                returnModel.setMsg("该用户未登录！");
                return returnModel;
            }
            redisUtils.deleteHash(LOGIN_USER,userId);
            returnModel.setMsg("退出登录成功!");
            returnModel.setSuccess(true);
        } catch (Exception e) {
            returnModel.setSuccess(false);
            log.error(e.getMessage());
        }
        return returnModel;
    }


    /**
     * 401跳转的地点
     */
    @RequestMapping(path = "/401",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ApiOperation(value = "/401",notes = "/401跳转的地点")
    public ReturnModel unauthorized(String message) {
        return new ReturnModel(401, message);
    }


    @GetMapping("/showToken")
    public String showToken(){
        User user = new User();
        user.setId("123456789");
        String token = com.iemp.auth.authcenter.common.JwtToken.createToken(user);
        return token;
    }

    @GetMapping("/parseToken")
    public Object parseToken(String token){
      String userId =  JwtToken.verifyToken(token);
        if(userId != null){
            return userId;
        }
        return false;
    }

}
