package com.example.repository;

import com.example.dto.ClinicDTO;
import com.example.entity.ClinicEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicRepository extends CrudRepository<ClinicEntity, Integer> {
    Optional<ClinicEntity> findByName(String phone);
    Optional<ClinicEntity> findByPhone(String phone);

    //      3. get all
    List<ClinicEntity> findAllByVisibleTrue();

    @Transactional
    @Modifying
    @Query("update ClinicEntity set visible = false where id = :id")
    int deleteClinicById(int id);

    Optional<ClinicEntity> findByIdAndVisibleTrue(int id);
    @Query("select new com.example.dto.ClinicDTO(id, name, address, phone, imageId) from ClinicEntity where visible = true ")
    Page<ClinicDTO> findAllByVisibleTrue(Pageable pageable);
}
