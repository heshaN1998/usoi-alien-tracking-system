package com.soft_universe.tranneer.exceptions;

import java.time.LocalDateTime;

public class ErrorResponceDTO {
    private  String message;
    private int status;
    private LocalDateTime timestamp;

    public ErrorResponceDTO(String message,int status,LocalDateTime timestamp){
        this.message=message;
        this.status=status;
        this.timestamp=timestamp;
    }
    public String getMessage(){
        return message;
    }
    public int getStatus(){
        return status;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
}
//I alson can add dependency its ease.pring web error esponce
