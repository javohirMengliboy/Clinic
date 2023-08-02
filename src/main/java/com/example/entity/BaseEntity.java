package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String phone;

    @Column
    private Integer age;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}
