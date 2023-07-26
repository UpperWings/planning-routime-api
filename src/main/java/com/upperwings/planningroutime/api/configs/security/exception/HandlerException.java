package com.upperwings.planningroutime.api.configs.security.exception;


import org.hibernate.JDBCException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleDefaultException(Exception ex){
        var err = ex.getMessage();
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(err, false));
    }

    public record ResponseExceptionDto (String err, Boolean status){}
}
