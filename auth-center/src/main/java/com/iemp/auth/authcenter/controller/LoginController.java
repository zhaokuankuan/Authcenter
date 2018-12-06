package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.common.JwtUtil;
import com.iemp.auth.authcenter.common.ReturnModel;
import com.iemp.auth.authcenter.domain.User;
import com.iemp.auth.authcenter.domain.config.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author :Mr.kk
 * @date: 2018/11/30 13:27
 */
@RestController
@Slf4j
public class LoginController{


    /** 登陆
     * @param user
     * @return
     */
    @RequestMapping(value="/userlogin")
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
    public String logout(HttpServletRequest request){
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
        return  "redirect:http://127.0.0.1:8080/login";
    }

    //配合shiro配置中的默认访问url
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String getLogin(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response){
        return "login";
    }


    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String index(){
        log.info("访问了后端 /index  请求");
        return "index";
    }

    @RequestMapping(value="/error",method=RequestMethod.GET)
    public String unAuth(){
        return "403";
    }


}
