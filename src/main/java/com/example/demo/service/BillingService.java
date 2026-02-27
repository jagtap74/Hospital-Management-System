package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Billing;

public interface BillingService {

    void generateBill(int patientId, Billing billing);

    List<Billing> getAllBills();

    void deleteBill(int id);
}