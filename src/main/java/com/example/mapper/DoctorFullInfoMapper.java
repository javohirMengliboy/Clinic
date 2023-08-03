package com.example.mapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@ToString
public class DoctorFullInfoMapper {
    private String id;
    private String name;
    private String surname;
    private String specialty;
    private String imageId;
    private LocalTime startWorkingTime;
    private LocalTime endWorkingTime;
    private Integer floor;
    private Integer roomNumber;
    private Integer patientCount;
    private Integer nowPatient;
    private Integer lastPatient;
}
