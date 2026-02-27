package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BillingRepository;
import com.example.demo.dao.PatientRepository;
import com.example.demo.entity.Billing;
import com.example.demo.entity.Patient;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void generateBill(int patientId, Billing billing) {

        Patient patient = patientRepository.findById((int) patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        double total = billing.getConsultationFee()
                     + billing.getMedicineFee()
                     + billing.getRoomCharge();

        billing.setTotalAmount(total);
        billing.setPatient(patient);

        billingRepository.save(billing);
    }

    @Override
    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    @Override
    public void deleteBill(int id) {
        billingRepository.deleteById(id);
    }
}