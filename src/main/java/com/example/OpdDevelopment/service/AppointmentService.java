package com.example.OpdDevelopment.service;

import com.example.OpdDevelopment.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getTodayAppointments();
}