package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}