package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BaseDTO {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private Integer age;
    private LocalDateTime createdDate;

    public BaseDTO() {
    }

    public BaseDTO(String id, String name, String surname, String phone, Integer age, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
        this.createdDate = createdDate;
    }
}
