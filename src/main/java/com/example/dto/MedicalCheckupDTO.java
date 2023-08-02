package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MedicalCheckupDTO {
    private String id;
    private String patientId;
    private String doctorId;
    private String diagnosis;
    private String recipeImage;
    private LocalDateTime createdDate;

    public MedicalCheckupDTO() {
    }

    public MedicalCheckupDTO(String id, String patientId, String doctorId, String diagnosis, String recipeImage, LocalDateTime createdDate) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.recipeImage = recipeImage;
        this.createdDate = createdDate;
    }
}
