package com.expense.expection;

import com.expense.domain.ExpenseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ExceptionProcessor {

    @ExceptionHandler(ExpenseException.class)
    public ResponseEntity<?> handleServiceException(ExpenseException ex, WebRequest webRequest){
        log.info("Expense Error: {}", ExceptionUtils.getStackTrace(ex));
        return new ResponseEntity<>(ExpenseResponseVO.builder()
                .errorCode(ex.getExceptionType().getCode())
                .errorMessage(ex.getMessage())
                .errorType(ex.getExceptionType().getDescription())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
