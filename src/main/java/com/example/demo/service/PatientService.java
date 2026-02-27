package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Patient;

public interface PatientService {

    Patient savePatient(Patient patient);

    List<Patient> getAllPatients();

    void deletePatient(int id);
}