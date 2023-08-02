package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceDTO {
    private Integer id;
    private String name;

    public ServiceDTO() {
    }

    public ServiceDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
