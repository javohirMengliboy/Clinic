package com.example.repository;

import com.example.dto.DoctorDTO;
import com.example.entity.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, String> {
    Optional<DoctorEntity> findByPhone(String phone);
    List<DoctorEntity> findAllBy();
    @Query("from DoctorEntity d inner join d.scheduleEntityList sch ")
    Page<DoctorEntity> findAllDoctor(Pageable pageable);
}
