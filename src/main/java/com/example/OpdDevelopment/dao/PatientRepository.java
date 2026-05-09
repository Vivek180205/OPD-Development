package com.example.OpdDevelopment.dao;

import com.example.OpdDevelopment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByNameContainingIgnoreCase(String name);

    List<Patient> findByPhoneNumberContaining(String phone);

    List<Patient> findByNameContainingIgnoreCaseOrPhoneNumberContaining(
            String name,
            String phone
    );
}