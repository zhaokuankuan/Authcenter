package com.iemp.auth.authcenter.domain.config;

import org.apache.shiro.authc.AuthenticationToken;

/**包装token的工具类
 * @author :Mr.kk
 * @date: 2018/12/6 11:05
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
