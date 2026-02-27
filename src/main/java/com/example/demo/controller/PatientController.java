package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // SAVE PATIENT
    @PostMapping("/save")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return ResponseEntity.ok("Patient Saved Successfully");
    }

    // GET ALL PATIENTS
    @GetMapping("/get")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // DELETE PATIENT
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient Deleted Successfully");
    }
}