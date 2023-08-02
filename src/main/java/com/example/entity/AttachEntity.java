package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "attaches")
public class AttachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "original_name")
    private String originalName;

    @Column()
    private String path;

    @Column()
    private Long size;

    @Column()
    private String extension;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToOne(mappedBy = "image")
    private ClinicEntity clinic;

    @OneToOne(mappedBy = "image")
    private MedicalCheckupEntity checkup;
}
