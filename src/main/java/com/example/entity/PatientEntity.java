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
@Table(name = "patients")
public class PatientEntity extends BaseEntity{

    @OneToMany(mappedBy = "patient")
    private List<MedicalCheckupEntity> medicalCheckupEntityList;
}
