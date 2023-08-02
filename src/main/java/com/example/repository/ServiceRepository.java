package com.example.repository;

import com.example.entity.PatientEntity;
import com.example.entity.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Integer> {
    List<ServiceEntity> findAllBy();

    @Query("from ServiceEntity")
    Page<ServiceEntity> findAllPatient(Pageable pageable);

    Optional<ServiceEntity> findByName(String name);
}
