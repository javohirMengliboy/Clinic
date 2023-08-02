package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "clinics_and_services")
public class ClinicsAndServicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "clinic_id")
    private Integer clinicId;
    @ManyToOne
    @JoinColumn(name = "clinic_id", insertable = false,updatable = false)
    private ClinicEntity clinic;

    @Column(name = "service_id")
    private Integer serviceId;
    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false,updatable = false)
    private ServiceEntity service;

    @Column()
    private Double price;
}
