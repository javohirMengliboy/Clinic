package com.example.entity;

import com.example.enums.QueueStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "queues")
public class QueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "order_number")
    private Integer orderNumber;

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

    @Column(name = "patient_id")
    private String patientId;
    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false,updatable = false)
    private PatientEntity patient;

    @Column()
    private QueueStatus status = QueueStatus.WAITING;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
