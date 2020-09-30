package com.pocpostgres.demo.exception.model;

import lombok.Data;

@Data
public class ErrorFieldDetail {
    private String field;
    private String message;
}
