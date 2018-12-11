package com.iemp.auth.authcenter.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.iemp.auth.authcenter.domain.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :Mr.kk
 * @date: 2018/12/10 18:25
 */
public class JwtToken {

    public static final String SCRET = "123456";


    /**
     * 根据公钥和用户的id生成token
     * @return token
     */
    public static String createToken(User user){
        //签发时间
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,2);
        Date expiresDate = calendar.getTime();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token = JWT.create()
                        .withHeader(map) //header
                        .withClaim("user",user.getId()) //payload
                        .withExpiresAt(expiresDate) //设置过期时间
                        .withIssuedAt(date) //设置签发时间
                        .sign(Algorithm.HMAC256(SCRET));
        return token;
    }

    /**
     * 根据用户的token和公钥验证token的时间
     * @return map
     */
    public static  String verifyToken(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SCRET)).build();
        DecodedJWT jwt = null;
        String userId = "";
        try {
            jwt = jwtVerifier.verify(token);
            if(null != jwt){
                Claim claim = jwt.getClaims().get("user");
                userId = claim.asString();
            }
        }catch (Exception e){
            throw new RuntimeException("token已过期，请重新登录!");
        }
        return  userId;
    }

}
