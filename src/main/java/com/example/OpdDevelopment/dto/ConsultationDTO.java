package com.example.OpdDevelopment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDTO {

    private Long id;

    private Long appointmentId;

    private String bloodPressure;

    private String temperature;

    private String notes;

    private Boolean completed;
}