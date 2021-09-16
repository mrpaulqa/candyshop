package com.candyshop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CandyNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CandyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String candyNotFoundHandler(CandyNotFoundException ex) {
        return ex.getMessage();
    }
}
