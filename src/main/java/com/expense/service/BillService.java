package com.expense.service;

import com.expense.domain.BillVO;
import com.expense.functions.BillFunctions;
import com.expense.repository.BillRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

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
}
