package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "hospital_rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "clinic_id")
    private Integer clinicId;
    @ManyToOne()
    @JoinColumn(name = "clinic_id", insertable = false,updatable = false)
    private ClinicEntity clinic;

    @Column(name = "floor_number")
    private Integer floorNumber;

    @Column(name = "is_empty")
    private Boolean isEmpty;

    @OneToOne(mappedBy = "room")
    private DoctorEntity doctor;
}
