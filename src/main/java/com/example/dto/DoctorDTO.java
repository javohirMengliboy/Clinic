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
    private List<ScheduleDTO> scheduleList;
    private Integer roomId;
    private Integer experience;
    public DoctorDTO() {
    }

    public DoctorDTO(String id, String name, String surname, String phone, Integer age, LocalDateTime createdDate, String specialty, List<ScheduleDTO> scheduleList, Integer roomId, Integer experience) {
        super(id, name, surname, phone, age, createdDate);
        this.specialty = specialty;
        this.scheduleList = scheduleList;
        this.roomId = roomId;
        this.experience = experience;
    }
}
