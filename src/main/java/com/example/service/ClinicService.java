package com.example.service;

import com.example.controller.AttachController;
import com.example.dto.ClinicDTO;
import com.example.entity.ClinicEntity;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import com.example.repository.ClinicRepository;
import com.example.util.ProfileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AttachController attachController;
    //      1. create
    public ClinicDTO create(ClinicDTO dto) {
        check(dto);
        ClinicEntity entity = new ClinicEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setImageId(dto.getImageId());
        clinicRepository.save(entity);
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setVisible(entity.getVisible());
        return dto;
    }

    //      2. get by id
    public ClinicDTO getById(int id) {
        ClinicDTO dto = clinicRepository.findByIdAndVisibleTrue(id).map(this::toDTO).orElseThrow(()->  new ItemNotFoundException("Clinic not found"));
//        attachController.open(dto.getImageId());
        return dto;
    }

    //      3. get all
    public List<ClinicDTO> getAll() {
        List<ClinicEntity> entityList =  clinicRepository.findAllByVisibleTrue();
        if (entityList.isEmpty()){
            throw new ItemNotFoundException("Clinic not found");
        }
       return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    //      4. update clinic
    public Boolean update(ClinicDTO dto, int id) {
        checkName(dto.getName());
        ClinicEntity entity = get(id);
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setImageId(dto.getImageId());
        clinicRepository.save(entity);
        return true;
    }

    //      5. delete clinic
    public Boolean delete(int id) {
        ClinicEntity entity = get(id);
        clinicRepository.delete(entity);
        return true;
//        int effectedRows = clinicRepository.deleteClinicById(id);
//        return effectedRows > 0;
    }


    //----------------------------------------------------------------------------------
    private void check(ClinicDTO dto) {
        checkName(dto.getName());
        checkPhone(dto.getPhone());
    }
    private void checkName(String name) {
        Optional<ClinicEntity> entityByName = clinicRepository.findByName(name);
        if (entityByName.isPresent()){
            throw new AppBadRequestException("This name already used");
        }
        if (name.length() < 3 || name.isBlank()){
            throw new AppBadRequestException("There are not enough characters");
        }
        ProfileUtil.isCapital(name);
    }

    private void checkPhone(String phone) {
        Optional<ClinicEntity> entityByPhone = clinicRepository.findByPhone(phone);
        if (entityByPhone.isPresent()){
            throw new AppBadRequestException("This phone already used");
        }
        ProfileUtil.checkingPhone(phone);
    }

    private ClinicDTO toDTO(ClinicEntity entity) {
        ClinicDTO dto = new ClinicDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setImageId(entity.getImageId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setVisible(entity.getVisible());
        return dto;
    }

    public Page<ClinicDTO> pagination(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("name"));
        return clinicRepository.findAllByVisibleTrue(pageable);
    }

    public ClinicEntity get(Integer id){
        return clinicRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Clinic not found"));
    }

    //--------------------------------------------------------------
}
