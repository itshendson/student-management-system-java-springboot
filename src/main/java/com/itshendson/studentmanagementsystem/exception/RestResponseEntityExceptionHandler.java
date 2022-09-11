package com.itshendson.studentmanagementsystem.exception;

import com.itshendson.studentmanagementsystem.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * This class's responsibility is to handle all exceptions that you want to send back as a response.
 */
@ControllerAdvice // The Controller Advice works for the whole package, not a specific file.
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleRestRequestException(StudentNotFoundException exception, WebRequest request) {
        ErrorMessage studentNotFoundMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage(), ZonedDateTime.now(ZoneId.of("Z")));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentNotFoundMessage);
    }
}
