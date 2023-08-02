package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PatientsDTO extends BaseDTO{
    public PatientsDTO() {
    }

    public PatientsDTO(String id, String name, String surname, String phone, Integer age, LocalDateTime createdDate) {
        super(id, name, surname, phone, age, createdDate);
    }
}
