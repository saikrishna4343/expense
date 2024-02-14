package com.expense.enums;

import com.expense.expection.ExceptionType;
import com.expense.expection.ExpenseException;

public enum BillTypes {
    CAR("CAR"),
    GROCERIES("GROCERIES"),
    RESTAURANT("RESTAURANT"),
    ELECTRICITY("ELECTRICITY"),
    ENTERTAINMENT("ENTERTAINMENT"),
    GAS("GAS"),
    GYM("GYM"),
    CREDIT_CARD("CREDIT CARD"),
    RENT("RENT"),
    INTERNET("INTERNET"),
    PHONE("PHONE"),
    OTHER("OTHER");

    public final String description;

    BillTypes(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public static BillTypes getEnumValue(String value){
        try{
            return Enum.valueOf(BillTypes.class, value);
        }catch (Exception e){
            throw new ExpenseException(ExceptionType.VALIDATION_EXCEPTION, String.format("Not a valid enum value %s", value));
        }
    }
}
