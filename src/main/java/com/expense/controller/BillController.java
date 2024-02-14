package com.expense.controller;

import com.expense.domain.BillVO;
import com.expense.service.BillService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "v1/bill")
@AllArgsConstructor
@Slf4j
public class BillController {

    BillService billService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewBill(@RequestBody BillVO billVO){
        return ResponseEntity.ok(billService.addNewBill(billVO));
    }

    @GetMapping(path = "/bill-number",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewBill(@RequestParam(name = "billNumber") UUID uuid){
        return ResponseEntity.ok(billService.getBillByBillNumber(uuid));
    }

    @GetMapping(path = "/bill-type",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewBill(@RequestParam(name = "billType") String billType){
        return ResponseEntity.ok(billService.getBillByBillType(billType));
    }
}
