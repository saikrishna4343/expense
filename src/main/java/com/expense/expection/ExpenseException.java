package com.expense.expection;

import lombok.Data;

@Data
public class ExpenseException extends RuntimeException{

    public ExceptionType exceptionType;
    private String message;

    public ExpenseException(ExceptionType exceptionType, String message){
        this.exceptionType = exceptionType;
        this.message = message;
    }
}
