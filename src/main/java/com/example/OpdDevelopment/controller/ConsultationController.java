package com.example.OpdDevelopment.controller;

import com.example.OpdDevelopment.dto.ConsultationDTO;
import com.example.OpdDevelopment.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ConsultationController {

    private final ConsultationService consultationService;

    @PostMapping
    public ConsultationDTO addConsultation(
            @RequestBody ConsultationDTO consultationDTO
    ) {

        return consultationService.addConsultation(consultationDTO);
    }

    @GetMapping("/patient/{patientId}")
    public List<ConsultationDTO> getPatientConsultations(
            @PathVariable Long patientId
    ) {

        return consultationService.getPatientConsultations(patientId);
    }
}