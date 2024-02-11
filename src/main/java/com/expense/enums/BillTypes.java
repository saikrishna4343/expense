package com.expense.enums;

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
        return Enum.valueOf(BillTypes.class, value);
    }
}
