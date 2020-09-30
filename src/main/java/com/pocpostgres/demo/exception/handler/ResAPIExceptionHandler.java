package com.pocpostgres.demo.exception.handler;

import com.pocpostgres.demo.exception.model.ErrorFieldDetail;
import com.pocpostgres.demo.exception.model.ErrorResponseBase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResAPIExceptionHandler extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorFieldDetail> fields = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            FieldError fieldError = (FieldError) error;
            ErrorFieldDetail detail = new ErrorFieldDetail();
            detail.setField(fieldError.getField());
            detail.setMessage(error.getDefaultMessage());
            fields.add(detail);
        }
        String pathUrl = ((ServletWebRequest)request).getRequest().getRequestURI().toString();
        ErrorResponseBase error = new ErrorResponseBase();
        error.setMessage("Validate Failed");
        error.setPath(pathUrl);
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setError(fields);
        return new ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String pathUrl = ((ServletWebRequest)request).getRequest().getRequestURI().toString();
        ErrorResponseBase error = new ErrorResponseBase();
        error.setMessage("No message available");
        error.setPath(pathUrl);
        error.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
        error.setError("Mothod Not Allowed");
        return new ResponseEntity(error, HttpStatus.METHOD_NOT_ALLOWED);
    }


}