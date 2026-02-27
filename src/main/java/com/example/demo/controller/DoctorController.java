package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // SAVE DOCTOR
    @PostMapping("/save")
    public ResponseEntity<String> saveDoctor(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return ResponseEntity.ok("Doctor Saved Successfully");
    }

    // GET ALL DOCTORS
    @GetMapping("/get")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // DELETE DOCTOR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor Deleted Successfully");
    }
}