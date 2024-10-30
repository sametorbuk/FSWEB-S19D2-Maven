package com.workintech.s18d4.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankException extends RuntimeException{
    private HttpStatus status;

    public BankException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
