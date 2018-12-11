package com.iemp.auth.authcenter.config;

import com.iemp.auth.authcenter.common.JwtToken;
import com.iemp.auth.authcenter.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/** shiro的MyRealm
 * @author :Mr.kk
 * @date: 2018/12/6 11:15
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService sysUserService;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //String userid = JwtUtil.getUsername(principals.toString());
        //User user = sysUserService.getUserByAccount(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //simpleAuthorizationInfo.addRole(user.getRole());
        //Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
        //simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        if (token == null || "".equals(token)) {
            throw new AuthenticationException("token is null!");
        }
        // 解密获得username，用于和数据库进行对比
        String userId = com.iemp.auth.authcenter.common.JwtToken.verifyToken(token);
        if (userId == null) {
            throw new AuthenticationException("token is unAuthentication!");
        }

        //User user = sysUserService.getUserByAccount(username);
        //if (user == null) {
        //    throw new AuthenticationException("user is not exist!");
        //}

        //if (!JwtUtil.verify(token, username, user.getPassword())) {
        //    throw new AuthenticationException("token is error!");
        //}
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
