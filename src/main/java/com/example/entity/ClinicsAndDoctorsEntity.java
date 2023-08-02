package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clinics_and_doctors")
public class ClinicsAndDoctorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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
}
