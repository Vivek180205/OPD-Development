package com.example.OpdDevelopment.controller;

import com.example.OpdDevelopment.dto.AppointmentDTO;
import com.example.OpdDevelopment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO bookAppointment(
            @RequestBody AppointmentDTO appointmentDTO
    ) {

        return appointmentService.bookAppointment(appointmentDTO);
    }

    @GetMapping("/today")
    public List<AppointmentDTO> getTodayAppointments() {

        return appointmentService.getTodayAppointments();
    }
}