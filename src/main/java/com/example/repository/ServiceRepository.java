package com.example.repository;

import com.example.entity.ServicesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<ServicesEntity, Integer> {
    Optional<ServicesEntity> findByServiceNameAndClinicId(String serviceName, Integer id);

    List<ServicesEntity> findAllByClinicId(int id);
}
