package com.workintech.s18d4.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<BankErrorResponse> exceptionHandler(BankException exception){
        BankErrorResponse response=new BankErrorResponse(exception.getMessage(),System.currentTimeMillis(), exception.getStatus());
        return new ResponseEntity(response , exception.getStatus());
    }


    @ExceptionHandler
    public ResponseEntity<BankErrorResponse> runTimeExceptionHandler(Exception exception){
        BankErrorResponse response = new BankErrorResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
    }
}
