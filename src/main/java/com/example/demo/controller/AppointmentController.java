package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book/{patientId}/{doctorId}")
    public ResponseEntity<String> bookAppointment(
            @PathVariable int patientId,
            @PathVariable int doctorId,
            @RequestBody Appointment appointment) {

        appointmentService.bookAppointment(patientId, doctorId, appointment);
        return ResponseEntity.ok("Appointment Booked Successfully");
    }

    @GetMapping("/get")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment Deleted");
    }
}