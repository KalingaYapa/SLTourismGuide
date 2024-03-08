package com.project.sltourguide.exceptions;

import org.springframework.security.core.AuthenticationException;

public class MalformedJwtTokenException extends AuthenticationException {
    public MalformedJwtTokenException(String msg) {
        super(msg);
    }
}
