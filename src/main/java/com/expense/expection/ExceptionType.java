package com.expense.expection;

public enum ExceptionType {
    VALIDATION_EXCEPTION("VALIDATION EXCEPTION", 6000),
    DATABASE_EXCEPTION("DATABASE EXCEPTION", 6001),
    INTERNAL_EXCEPTION("INTERNAL EXCEPTION", 6002);

    public String description;
    public Integer code;

    ExceptionType(String description, Integer code){
        this.description = description;
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getDescription(){
        return this.description;
    }
}
