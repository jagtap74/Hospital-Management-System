package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Appointment;

public interface AppointmentService {

    void bookAppointment(int patientId, int doctorId, Appointment appointment);

    List<Appointment> getAllAppointments();

    void deleteAppointment(int id);
}