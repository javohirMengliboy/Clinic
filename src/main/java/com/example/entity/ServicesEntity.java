package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "services")
public class ServicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "clinic_id")
    private Integer clinicId;
    @ManyToOne
    @JoinColumn(name = "clinic_id", insertable = false,updatable = false)
    private ClinicEntity clinic;

    @Column(name = "service_name")
    private String serviceName;

    @Column()
    private Double price;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}
