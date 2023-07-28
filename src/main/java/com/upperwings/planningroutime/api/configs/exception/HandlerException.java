package com.upperwings.planningroutime.api.configs.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity handleInternalAuthenticationServiceExceptionException(Exception ex){
        var err = "Usuario ou senha invalidos";
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(err, false));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleDefaultException(Exception ex){
        var err = ex.getMessage();
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(err, false));
    }

    public record ResponseExceptionDto (String err, Boolean status){}
}
