package com.expense.functions;

import com.expense.domain.BillVO;
import com.expense.entity.Bill;
import com.expense.enums.BillTypes;

import java.util.function.Function;

public class BillFunctions {

    public static Function<BillVO, Bill> billVOToBillFn = billVO ->
            Bill.builder()
                    .billNumber(billVO.getBillNumber())
                    .billHeader(billVO.getBillHeader())
                    .billNotes(billVO.getBillNotes())
                    .billFrom(billVO.getBillFrom())
                    .billAmount(billVO.getBillAmount())
                    .billType(billVO.getBillType().getDescription())
                    .paid(billVO.getPaid())
                    .billCreatedDate(billVO.getBillCreatedDate())
                    .build();

    public static Function<Bill, BillVO> billToBillVOFn = bill ->
            BillVO.builder()
                    .billNumber(bill.getBillNumber())
                    .billHeader(bill.getBillHeader())
                    .billNotes(bill.getBillNotes())
                    .billFrom(bill.getBillFrom())
                    .billType(BillTypes.getEnumValue(bill.getBillType()))
                    .billAmount(bill.getBillAmount())
                    .paid(bill.getPaid())
                    .billCreatedDate(bill.getBillCreatedDate())
                    .build();
}
