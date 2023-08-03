package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateRoomDTO {
    private Integer clinicId;
    private Integer floors;
    private Integer numberOfRooms;
}
