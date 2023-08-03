package com.example.mapper;

import java.util.List;

public interface DoctorInfoMapper {
    String getName();
    String getSurname();
    String getImageId();
    Integer getAge();
    Integer getExperience();
    List<String> getWorkingDays();

}
