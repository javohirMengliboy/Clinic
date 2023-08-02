package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "medical_checkups")
public class MedicalCheckupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "patient_id")
    private String patientId;
    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false,updatable = false)
    private PatientEntity patient;

    @Column(name = "doctor_id")
    private String doctorId;
    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false,updatable = false)
    private DoctorEntity doctor;

    @Column()
    private String diagnosis;

    @Column(name = "recipe_image")
    private String recipeImage;
    @OneToOne()
    @JoinColumn(name = "recipe_image", insertable = false,updatable = false)
    private AttachEntity image;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();


}
