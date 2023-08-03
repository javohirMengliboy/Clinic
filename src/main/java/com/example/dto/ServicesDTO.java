package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ServicesDTO {
    private Integer id;
    private String serviceName;
    private Integer clinicId;
    private Double price;
    private LocalDateTime createdDate;


    public ServicesDTO() {
    }

    public ServicesDTO(Integer id, String serviceName, Integer clinicId, Double price, LocalDateTime createdDate) {
        this.id = id;
        this.serviceName = serviceName;
        this.clinicId = clinicId;
        this.price = price;
        this.createdDate = createdDate;
    }
}
