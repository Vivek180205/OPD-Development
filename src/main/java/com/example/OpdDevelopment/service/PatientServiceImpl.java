package com.example.OpdDevelopment.service;


import com.example.OpdDevelopment.dao.PatientRepository;
import com.example.OpdDevelopment.dto.PatientDTO;
import com.example.OpdDevelopment.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDTO addPatient(PatientDTO dto) {

        Patient patient = new Patient();

        patient.setName(dto.getName());
        patient.setGender(dto.getGender());
        patient.setAge(dto.getAge());
        patient.setPhoneNumber(dto.getPhoneNumber());

        Patient savedPatient = patientRepository.save(patient);

        dto.setId(savedPatient.getId());

        return dto;
    }

    @Override
    public List<PatientDTO> getAllPatients() {

        return patientRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<PatientDTO> searchPatients(String keyword) {

        List<Patient> patients =
                patientRepository.findByNameContainingIgnoreCaseOrPhoneNumberContaining(
                        keyword,
                        keyword
                );

        return patients.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private PatientDTO mapToDTO(Patient patient) {

        PatientDTO dto = new PatientDTO();

        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setGender(patient.getGender());
        dto.setAge(patient.getAge());
        dto.setPhoneNumber(patient.getPhoneNumber());

        return dto;
    }
}