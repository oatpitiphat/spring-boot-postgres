package com.pocpostgres.demo.exception.handler;

import com.pocpostgres.demo.exception.model.ErrorAttributesGetter;
import com.pocpostgres.demo.exception.model.NotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    private static final String ERROR_PATH=  "/error";
    private ErrorAttributesGetter errorAttributesGetter;

    /**
     * Just catching the {@linkplain NotFoundException} exceptions and render
     * the 404.jsp error page.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        return ResponseEntity.status(status).body(errorAttributesGetter.getErrorAttributes(request));
    }

    /**
     * Responsible for handling all errors and throw especial exceptions
     * for some HTTP status codes. Otherwise, it will return a map that
     * ultimately will be converted to a json error.
     */
    @RequestMapping(ERROR_PATH)
    public ResponseEntity<?> handleErrors(HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        if (status.equals(HttpStatus.NOT_FOUND))
            throw new NotFoundException();

        return ResponseEntity.status(status).body(errorAttributesGetter.getErrorAttributes(request));
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }
}

