package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Doctor;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    void deleteDoctor(int id);
}