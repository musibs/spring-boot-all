package io.codefountain.spring.boot.ad.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransactionSystemException.class)
    protected ResponseEntity<List<String>> handleTransactionException(TransactionSystemException transactionSystemException) throws Throwable{
        Throwable cause = transactionSystemException.getCause();
        if(!(cause instanceof RollbackException)){
            throw cause;
        }
        else if(!(cause.getCause() instanceof ConstraintViolationException)){
            throw cause.getCause();
        }

        ConstraintViolationException constraintViolationException = (ConstraintViolationException) cause.getCause();
        List<String> validationFailureMessages = constraintViolationException.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        return new ResponseEntity<>(validationFailureMessages, HttpStatus.BAD_REQUEST);
    }
}
