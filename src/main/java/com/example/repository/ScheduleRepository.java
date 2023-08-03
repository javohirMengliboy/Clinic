package com.example.repository;

import com.example.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Integer> {
    @Query("select weekDay from ScheduleEntity where doctorId = :doctorId")
    List<String> getWorkingDaysByDoctorId(String doctorId);
}
