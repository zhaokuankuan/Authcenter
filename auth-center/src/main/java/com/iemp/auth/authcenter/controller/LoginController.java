package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.JwtUtil;
import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.User;
import com.iemp.auth.authcenter.domain.config.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
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
public class LoginController{


    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ReturnModel requireAuth() {
        return new ReturnModel(200, "You are authenticated");
    }


    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ReturnModel requireRole() {
        return new ReturnModel(200, "You are visiting require_role");
    }

    /** 登陆
     * @param user
     * @return
     */
    @RequestMapping(value="/login")
    @ResponseBody
    public ReturnModel userLogin(User user){
        ReturnModel returnModel = new ReturnModel();
        if(user==null){
            returnModel.setMsg("登录失败");
            return returnModel;
        }
        String account=user.getLoginName();
        String password=user.getPassword();
        String token = JwtUtil.sign(account,password);
        JwtToken jwtToken = new JwtToken(token);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(jwtToken);
            returnModel.addDefaultModel("TOKEN", token);
            returnModel.setMsg("登录成功！");
            returnModel.setSuccess(true);
            //此步将 调用realm的认证方法
        } catch(IncorrectCredentialsException e){
            //这最好把 所有的 异常类型都背会
            returnModel.setMsg("账号或者密码错误！");
            return returnModel;
        } catch (AuthenticationException e) {
            returnModel.setMsg("登录失败！");
            return returnModel;
        }
        return returnModel;
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="/logout",method =RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
        //即使session托管给了redis ，redis有很多个浏览器的session
        //只要调用退出方法，此subject的、此浏览器的session就没了
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            String userId=user.getId();
            //退出
            SecurityUtils.getSubject().logout();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        response.sendRedirect("/AuthCenter/login");
    }


    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ReturnModel unauthorized(String message) {
        return new ReturnModel(401, message);
    }

}
