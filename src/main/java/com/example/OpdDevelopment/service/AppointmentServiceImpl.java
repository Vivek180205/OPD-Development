package com.example.OpdDevelopment.service;

import com.example.OpdDevelopment.dao.AppointmentRepository;
import com.example.OpdDevelopment.dao.PatientRepository;
import com.example.OpdDevelopment.dto.AppointmentDTO;
import com.example.OpdDevelopment.entity.Appointment;
import com.example.OpdDevelopment.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Override
    public AppointmentDTO bookAppointment(AppointmentDTO dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = new Appointment();

        appointment.setPatient(patient);
        appointment.setDoctorName(dto.getDoctorName());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setStatus("BOOKED");

        Appointment savedAppointment = appointmentRepository.save(appointment);

        dto.setId(savedAppointment.getId());
        dto.setPatientName(savedAppointment.getPatient().getName());
        dto.setStatus(savedAppointment.getStatus());

        return dto;
    }

    @Override
    public List<AppointmentDTO> getTodayAppointments() {

        LocalDate today = LocalDate.now();

        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(LocalTime.MAX);

        return appointmentRepository
                .findByAppointmentTimeBetween(start, end)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private AppointmentDTO mapToDTO(Appointment appointment) {

        AppointmentDTO dto = new AppointmentDTO();

        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setDoctorName(appointment.getDoctorName());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setStatus(appointment.getStatus());

        return dto;
    }
}