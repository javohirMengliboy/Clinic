package com.example.service;

import com.example.dto.PatientsDTO;
import com.example.dto.ServiceDTO;
import com.example.entity.ServiceEntity;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import com.example.repository.ClinicsAndDoctorsRepository;
import com.example.repository.ScheduleRepository;
import com.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.util.ProfileUtil.isCapital;


@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClinicsAndDoctorsRepository clinicsAndDoctorsRepository;


    //      1. create
    public ServiceDTO create(ServiceDTO dto) {

        ServiceEntity entity = new ServiceEntity();
        entity.setName(dto.getName());
        serviceRepository.save(entity);
        dto.setId(entity.getId());
        return null;
    }

    //      2. get by id
    public ServiceDTO getById(int id) {
        return serviceRepository.findById(id).map(this::toDTO).orElseThrow(() -> new ItemNotFoundException("Clinic not found"));
    }

    //      3. get all
    public List<ServiceDTO> getAll() {
        List<ServiceEntity> entityList = serviceRepository.findAllBy();
        if (entityList.isEmpty()) {
            throw new ItemNotFoundException("Service not found");
        }
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    //      4. update clinic
    public Boolean update(ServiceDTO dto, Integer id) {
        ServiceEntity entity = serviceRepository.findById(id).get();
        entity.setName(dto.getName());
        serviceRepository.save(entity);
        return true;
    }

    //      5. delete clinic
    public Boolean delete(Integer id) {
        serviceRepository.deleteById(id);
        return true;
    }



    // ---------------------------------------------------------

    public void checkingName(String name) {
        Optional<ServiceEntity> serviceEntity = serviceRepository.findByName(name);
        if (serviceEntity.isPresent()) {
            throw new AppBadRequestException("This phone already exists");
        }
        if (name.length() < 3 || name.isBlank()) {
            throw new AppBadRequestException("There are not enough characters");
        }
        isCapital(name);
    }

    private ServiceDTO toDTO(ServiceEntity entity) {
        ServiceDTO dto = new ServiceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
//--------------------------------------------------------------
}