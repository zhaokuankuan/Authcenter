package com.iemp.auth.authcenter.controller;

import com.iemp.auth.authcenter.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author :Mr.kk
 * @date: 2018/11/30 13:27
 */
@RestController
public class LoginController {

    @RequestMapping(value="/userlogin")
    public String userLogin(Model model, User user, HttpServletResponse response){
        if(user==null){return "login";}
        String account=user.getLoginName();
        String password=user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password,false);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            //此步将 调用realm的认证方法
        } catch(IncorrectCredentialsException e){
            //这最好把 所有的 异常类型都背会
            model.addAttribute("message", "密码错误");
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("message", "登录失败");
            return "login";
        }
        return "index";
    }

    //配合shiro配置中的默认访问url
    @RequestMapping(value="/login")
    public String getLogin(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response){
        return "login";
    }

    @RequestMapping(value="/hello")
    public String hello(){
        return "NewFile";
    }

    @RequestMapping(value="/")
    public String index(){
        System.out.println("访问了后端 /  请求");
        return "login";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){

        //subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
        //即使session托管给了redis ，redis有很多个浏览器的session
        //只要调用退出方法，此subject的、此浏览器的session就没了
        try {
            //退出
            SecurityUtils.getSubject().logout();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "login";

    }

    @RequestMapping(value="403")
    public String unAuth(){

        return "403";
    }
}
