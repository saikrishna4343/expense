package com.expense.domain;

import com.expense.enums.BillTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillVO {
    private UUID billNumber;
    private String billHeader;
    private String billNotes;
    private String billFrom;
    private BillTypes billType;
    private BigDecimal billAmount;
    private Boolean paid;
    private ZonedDateTime billCreatedDate;
}
