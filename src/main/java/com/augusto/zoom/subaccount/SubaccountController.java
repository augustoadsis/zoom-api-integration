package com.augusto.zoom.subaccount;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subaccounts")
@Slf4j
public class SubaccountController {

    @Autowired
    SubaccountService subaccountService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return subaccountService.fildAll();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody SubaccountRequest request) {
        SubaccountResponse subaccount = subaccountService.create(request);
        return ResponseEntity.status(HttpStatus.OK).body(subaccount);
    }

}
