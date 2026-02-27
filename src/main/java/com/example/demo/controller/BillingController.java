package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Billing;
import com.example.demo.service.BillingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/generate/{patientId}")
    public ResponseEntity<String> generateBill(
            @PathVariable int patientId,
            @RequestBody Billing billing) {

        billingService.generateBill(patientId, billing);
        return ResponseEntity.ok("Bill Generated Successfully");
    }

    @GetMapping("/get")
    public List<Billing> getAllBills() {
        return billingService.getAllBills();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable int id) {
        billingService.deleteBill(id);
        return ResponseEntity.ok("Bill Deleted");
    }
}