package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clinics")
public class ClinicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column()
    private String address;

    @Column(unique = true)
    private String phone;

    @Column(name = "image_id")
    private String imageId;
    @OneToOne
    @JoinColumn(name = "image_id")
    private AttachEntity image;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column()
    private Boolean visible = true;

    @OneToMany(mappedBy = "clinic")
    private List<ClinicsAndServicesEntity> clinicsAndServicesEntityList;

    @OneToMany(mappedBy = "clinic")
    private List<ClinicsAndDoctorsEntity> clinicsAndDoctorsEntityList;
}
