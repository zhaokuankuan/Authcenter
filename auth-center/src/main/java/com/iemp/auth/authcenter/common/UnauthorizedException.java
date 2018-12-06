package com.iemp.auth.authcenter.common;

import org.springframework.stereotype.Component;

/**
 * @author :Mr.kk
 * @date: 2018/12/6 15:57
 */
@Component
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
