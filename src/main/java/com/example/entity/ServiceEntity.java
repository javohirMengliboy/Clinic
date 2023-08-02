package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "services")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column()
    private Boolean visible;

    @OneToMany(mappedBy = "service")
    private List<ClinicsAndServicesEntity> clinicsAndServicesEntityList;

}
