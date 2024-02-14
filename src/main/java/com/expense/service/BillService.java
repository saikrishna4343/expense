package com.expense.service;

import com.expense.domain.BillVO;
import com.expense.entity.Bill;
import com.expense.expection.ExceptionType;
import com.expense.expection.ExpenseException;
import com.expense.functions.BillFunctions;
import com.expense.repository.BillRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class BillService {

    BillRepository billRepository;

    public BillVO addNewBill(BillVO billVO){
        billVO.setBillNumber(UUID.randomUUID());
        billVO.setBillCreatedDate(ZonedDateTime.now());
        return BillFunctions.billToBillVOFn.apply(billRepository.save(BillFunctions.billVOToBillFn.apply(billVO)));
    }

    public BillVO getBillByBillNumber(UUID billNumber){
        Bill bill = billRepository.findByBillNumber(billNumber).orElseThrow(()-> new ExpenseException(ExceptionType.INTERNAL_EXCEPTION, String.format("No record found with id: %s", billNumber)));
        return BillFunctions.billToBillVOFn.apply(bill);
    }

    public List<BillVO> getBillByBillType(String billType){
        Specification<Bill> specification = Specification.where(billRepository.billTypeSpecification(billType));
        List<Bill> bills = billRepository.findAll(specification);
        return bills.stream().map(e-> BillFunctions.billToBillVOFn.apply(e)).collect(Collectors.toList());
    }
}
