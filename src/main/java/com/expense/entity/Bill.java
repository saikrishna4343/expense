package com.expense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity(name = "bills")
public class Bill extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UUID billNumber;
    private String billHeader;
    private String billNotes;
    private String billFrom;
    private String billType;
    private BigDecimal billAmount;
    private Boolean paid;
    private ZonedDateTime billCreatedDate;
}
