package com.example.OpdDevelopment.service;

import com.example.OpdDevelopment.dto.PatientDTO;
import java.util.List;

public interface PatientService {

    PatientDTO addPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    List<PatientDTO> searchPatients(String keyword);
}