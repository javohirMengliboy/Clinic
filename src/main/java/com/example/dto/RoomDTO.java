package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomDTO {
    private String id;
    private Integer orderNumber;
    private Integer clinicId;
    private Integer floorNumber;
    private Boolean isEmpty;

    public RoomDTO() {
    }

    public RoomDTO(String id, Integer orderNumber, Integer clinicId, Integer floorNumber, Boolean isEmpty) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.clinicId = clinicId;
        this.floorNumber = floorNumber;
        this.isEmpty = isEmpty;
    }
}
