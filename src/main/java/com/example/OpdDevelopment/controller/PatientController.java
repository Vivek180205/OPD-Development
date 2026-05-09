package com.example.OpdDevelopment.controller;

import com.example.OpdDevelopment.dto.PatientDTO;
import com.example.OpdDevelopment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {

        return patientService.addPatient(patientDTO);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {

        return patientService.getAllPatients();
    }

    @GetMapping("/search")
    public List<PatientDTO> searchPatients(
            @RequestParam String keyword
    ) {

        return patientService.searchPatients(keyword);
    }
}