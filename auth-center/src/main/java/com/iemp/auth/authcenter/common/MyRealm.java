package com.iemp.auth.authcenter.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 测试Realm域
 * @author :Mr.kk
 * @date: 2018/11/29 16:11
 */
public class MyRealm implements Realm {
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //凭证的账号
        String username = (String)authenticationToken.getPrincipal();  //得到用户名
        //凭证的密码
        String password = new String((char[])authenticationToken.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
