package com.example.OpdDevelopment.service;

import com.example.OpdDevelopment.dto.ConsultationDTO;

import java.util.List;

public interface ConsultationService {

    ConsultationDTO addConsultation(ConsultationDTO consultationDTO);

    List<ConsultationDTO> getPatientConsultations(Long patientId);
}