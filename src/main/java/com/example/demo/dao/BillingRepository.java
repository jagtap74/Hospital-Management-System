package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer> {
}