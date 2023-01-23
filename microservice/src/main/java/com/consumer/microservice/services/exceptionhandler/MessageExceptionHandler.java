package com.consumer.microservice.services.exceptionhandler;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MessageExceptionHandler {

    private Date timestamp;
    private Integer status;
    private String message;
}
