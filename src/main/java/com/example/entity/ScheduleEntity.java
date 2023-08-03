package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "schedules")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "week_day")
    private String weekDay;

    @Column(name = "star_working_time")
    private LocalTime startWorkingTime;

    @Column(name = "end_working_time")
    private LocalTime endWorkingTime;

    @Column(name = "doctor_id")
    private String doctorId;
    @ManyToOne()
    @JoinColumn(name = "doctor_id",insertable = false, updatable = false)
    private DoctorEntity doctor;

}
