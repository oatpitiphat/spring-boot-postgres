package com.pocpostgres.demo.exception.model;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ErrorAttributesGetter {

    /**
     * Extract error information.
     *
     * @param req request information
     * @return error information
     */
    public static Map<String, Object> getErrorAttributes(HttpServletRequest req) {
        // Get detailed error information with DefaultErrorAttributes class
        ServletWebRequest swr = new ServletWebRequest(req);
        DefaultErrorAttributes dea = new DefaultErrorAttributes();
        ErrorAttributeOptions eao = ErrorAttributeOptions.of(
                ErrorAttributeOptions.Include.BINDING_ERRORS,
                ErrorAttributeOptions.Include.MESSAGE);
        return dea.getErrorAttributes(swr, eao);
    }
}