package com.workintech.s18d4.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
public class BankErrorResponse {
    private String message;
    private int status;
    private long timeStamps;

    public BankErrorResponse(String message, long timeStamps, HttpStatus status) {
        this.message = message;
        this.timeStamps = timeStamps;
        this.status = status.value();
    }
}
