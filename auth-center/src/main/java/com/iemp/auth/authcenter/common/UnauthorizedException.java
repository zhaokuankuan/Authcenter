package com.iemp.auth.authcenter.common;

/**
 * @author :Mr.kk
 * @date: 2018/12/6 15:57
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
