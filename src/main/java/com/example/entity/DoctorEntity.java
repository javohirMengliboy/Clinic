package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class DoctorEntity extends BaseEntity{
    @Column()
    private String specialty;

    @Column(name = "room_id")
    private Integer roomId;
    @OneToOne()
    @JoinColumn(name = "room_id", insertable = false,updatable = false)
    private RoomEntity room;

    @Column()
    private Integer experience;

    @OneToMany(mappedBy = "doctor")
    private List<ScheduleEntity> scheduleEntityList;

    @OneToMany(mappedBy = "doctor")
    private List<MedicalCheckupEntity> medicalCheckupEntityList;

    @OneToMany(mappedBy = "doctor")
    private List<ClinicsAndDoctorsEntity> clinicsAndDoctorsEntityList;
}
