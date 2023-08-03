package com.example.repository;

import com.example.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {
    List<RoomEntity> findAllByClinicId(Integer clinicId);

    Optional<RoomEntity> findByOrderNumber(Integer orderNumber);
}
