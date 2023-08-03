package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class DoctorDTO extends BaseDTO{
    private String specialty;
    private String imageId;
    private List<ScheduleDTO> scheduleList;
    private Integer roomNumber;
    private Integer experience;
    public DoctorDTO() {
    }

    public DoctorDTO(String id, String name, String surname, String phone, Integer age, LocalDateTime createdDate, String specialty, String imageId, List<ScheduleDTO> scheduleList, Integer roomNumber, Integer experience) {
        super(id, name, surname, phone, age, createdDate);
        this.specialty = specialty;
        this.imageId = imageId;
        this.scheduleList = scheduleList;
        this.roomNumber = roomNumber;
        this.experience = experience;
    }
}
