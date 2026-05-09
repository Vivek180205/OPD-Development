package com.example.OpdDevelopment.service;

import com.example.OpdDevelopment.dao.AppointmentRepository;
import com.example.OpdDevelopment.dao.ConsultationRepository;
import com.example.OpdDevelopment.dto.ConsultationDTO;
import com.example.OpdDevelopment.entity.Appointment;
import com.example.OpdDevelopment.entity.Consultation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    public ConsultationDTO addConsultation(ConsultationDTO dto) {

        Appointment appointment =
                appointmentRepository.findById(dto.getAppointmentId())
                        .orElseThrow(() ->
                                new RuntimeException("Appointment not found"));

        Consultation consultation = new Consultation();

        consultation.setAppointment(appointment);
        consultation.setBloodPressure(dto.getBloodPressure());
        consultation.setTemperature(dto.getTemperature());
        consultation.setNotes(dto.getNotes());
        consultation.setCompleted(true);

        Consultation savedConsultation =
                consultationRepository.save(consultation);

        appointment.setStatus("COMPLETED");
        appointmentRepository.save(appointment);

        dto.setId(savedConsultation.getId());

        return dto;
    }

    @Override
    public List<ConsultationDTO> getPatientConsultations(Long patientId) {

        return consultationRepository
                .findByAppointmentPatientId(patientId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private ConsultationDTO mapToDTO(Consultation consultation) {

        ConsultationDTO dto = new ConsultationDTO();

        dto.setId(consultation.getId());
        dto.setAppointmentId(
                consultation.getAppointment().getId()
        );

        dto.setBloodPressure(consultation.getBloodPressure());
        dto.setTemperature(consultation.getTemperature());
        dto.setNotes(consultation.getNotes());
        dto.setCompleted(consultation.getCompleted());

        return dto;
    }
}