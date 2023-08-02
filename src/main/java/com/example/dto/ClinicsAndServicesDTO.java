package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClinicsAndServicesDTO {
    private Integer id;
    private Integer clinicId;
    private Integer serviceId;
    private Double price;

    public ClinicsAndServicesDTO() {
    }

    public ClinicsAndServicesDTO(Integer id, Integer clinicId, Integer serviceId, Double price) {
        this.id = id;
        this.clinicId = clinicId;
        this.serviceId = serviceId;
        this.price = price;
    }
}
