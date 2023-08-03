package com.example.mapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DoctorMapper {
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String specialty;
    private String imageId;
    private Integer experience;
    private List<String> workingDays;

    public DoctorMapper() {
    }

    public DoctorMapper(String id, String name, String surname, Integer age, String specialty, String imageId, Integer experience) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.specialty = specialty;
        this.imageId = imageId;
        this.experience = experience;
    }
}
