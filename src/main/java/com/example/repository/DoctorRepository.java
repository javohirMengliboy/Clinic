package com.example.repository;

import com.example.dto.DoctorDTO;
import com.example.entity.DoctorEntity;
import com.example.mapper.DoctorInfoMapper;
import com.example.mapper.DoctorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, String> {
    Optional<DoctorEntity> findByPhone(String phone);
    List<DoctorEntity> findAllBy();
    @Query("from DoctorEntity d inner join d.scheduleEntityList ")
    Page<DoctorEntity> findAllDoctor(Pageable pageable);

    @Query("select new com.example.mapper.DoctorMapper(id, name, surname, age, specialty, imageId, experience) from DoctorEntity where specialty = :specialty")
    List<DoctorMapper> getDoctorEntitiesBySpecialty(@Param("specialty") String specialty);

    @Query("select new com.example.mapper.DoctorMapper(id, name, surname, age, specialty, imageId, experience) from DoctorEntity where lower(name) like :value or lower(surname) like :value")
    List<DoctorMapper> search(@Param("value") String value);
}
