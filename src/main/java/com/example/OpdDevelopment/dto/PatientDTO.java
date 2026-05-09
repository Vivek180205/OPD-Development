package com.example.OpdDevelopment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Long id;

    private String name;

    private String gender;

    private Integer age;

    private String phoneNumber;
}