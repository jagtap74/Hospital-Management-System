package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "consultation_fee")
    private double consultationFee;

    @Column(name = "medicine_fee")
    private double medicineFee;

    @Column(name = "room_charge")
    private double roomCharge;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public double getMedicineFee() { return medicineFee; }
    public void setMedicineFee(double medicineFee) { this.medicineFee = medicineFee; }

    public double getRoomCharge() { return roomCharge; }
    public void setRoomCharge(double roomCharge) { this.roomCharge = roomCharge; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}