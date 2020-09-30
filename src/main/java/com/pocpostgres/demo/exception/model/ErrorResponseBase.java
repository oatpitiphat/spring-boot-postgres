package com.pocpostgres.demo.exception.model;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponseBase {
    public ErrorResponseBase() {
        this.timestamp = new Date();
    }
    private Object timestamp;
    private Integer status;
    private Object error;
    private String message;
    private String path;
}
