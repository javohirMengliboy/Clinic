package com.example.dto;

import com.example.enums.QueueStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class QueueDTO {
    private Integer id;
    private Integer orderNumber;
    private Integer clinicId;
    private String doctorId;
    private String patientId;
    private QueueStatus status;
    private LocalDateTime createdDate;

    public QueueDTO() {
    }

    public QueueDTO(Integer id, Integer orderNumber, Integer clinicId, String doctorId, String patientId, QueueStatus status, LocalDateTime createdDate) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.clinicId = clinicId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.status = status;
        this.createdDate = createdDate;
    }
}
