package com.expense.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseResponseVO {

    private String errorType;
    private Integer errorCode;
    private String errorMessage;

}
