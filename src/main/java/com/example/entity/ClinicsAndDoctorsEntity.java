package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "clinics_and_doctors")
public class ClinicsAndDoctorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clinic_id")
    private Integer clinicId;
    @ManyToOne
    @JoinColumn(name = "clinic_id", insertable = false,updatable = false)
    private ClinicEntity clinic;

    @Column(name = "doctor_id")
    private String doctorId;
    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false,updatable = false)
    private DoctorEntity doctor;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}
