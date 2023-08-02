package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class ClinicDTO {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String imageId;
    private LocalDateTime createdDate;
    private Boolean visible;

    public ClinicDTO() {
    }

    public ClinicDTO(Integer id, String name, String address, String phone, String imageId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.imageId = imageId;
    }

    public ClinicDTO(Integer id, String name, String address, String phone, String imageId, LocalDateTime createdDate, Boolean visible) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.imageId = imageId;
        this.createdDate = createdDate;
        this.visible = visible;
    }
}
