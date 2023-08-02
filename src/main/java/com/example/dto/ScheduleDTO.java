package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ScheduleDTO {
    private Integer id;
    private String weekDay;
    private LocalTime startWorkingTime;
    private LocalTime endWorkingTime;
    private String doctorId;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Integer id, String weekDay, LocalTime startWorkingTime, LocalTime endWorkingTime, String doctorId) {
        this.id = id;
        this.weekDay = weekDay;
        this.startWorkingTime = startWorkingTime;
        this.endWorkingTime = endWorkingTime;
        this.doctorId = doctorId;
    }
}
