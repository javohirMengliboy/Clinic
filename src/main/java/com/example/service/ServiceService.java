package com.example.service;

import com.example.dto.ServicesDTO;
import com.example.entity.ServicesEntity;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import com.example.repository.ClinicsAndDoctorsRepository;
import com.example.repository.ScheduleRepository;
import com.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.util.ProfileUtil.isCapital;


@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    //      1. create
    public ServicesDTO create(ServicesDTO dto) {
        checkingName(dto.getServiceName());
        Optional<ServicesEntity> optional = getByServiceNameAndClinicId(dto.getServiceName(), dto.getClinicId());
        if (optional.isPresent()){
            throw new AppBadRequestException("This service is available at this hospital");
        }
        ServicesEntity entity = new ServicesEntity();
        entity.setServiceName(dto.getServiceName());
        entity.setClinicId(dto.getClinicId());
        entity.setPrice(dto.getPrice());
        serviceRepository.save(entity);
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }



    //      2. get by clinic id
    public List<ServicesDTO> getAllByClinicId(int id) {
        return serviceRepository.findAllByClinicId(id).stream().map(this::toDTO).collect(Collectors.toList());
    }


    //      3. update clinic
    public Boolean update(ServicesDTO dto, Integer id) {
        checkingName(dto.getServiceName());
        ServicesEntity entity = get(id);
        entity.setServiceName(dto.getServiceName());
        entity.setClinicId(dto.getClinicId());
        entity.setPrice(dto.getPrice());
        serviceRepository.save(entity);
        return true;
    }

    //      4. delete clinic
    public Boolean delete(Integer id) {
        ServicesEntity entity = get(id);
        serviceRepository.delete(entity);
        return true;
    }



    // ---------------------------------------------------------

    private Optional<ServicesEntity> getByServiceNameAndClinicId(String serviceName, Integer clinicId) {
        return serviceRepository.findByServiceNameAndClinicId(serviceName,clinicId);
    }

    public void checkingName(String name) {
        if (name.length() < 3 || name.isBlank()) {
            throw new AppBadRequestException("There are not enough characters");
        }
        isCapital(name);
    }

    private ServicesDTO toDTO(ServicesEntity entity) {
        ServicesDTO dto = new ServicesDTO();
        dto.setId(entity.getId());
        dto.setServiceName(entity.getServiceName());
        dto.setClinicId(entity.getClinicId());
        dto.setPrice(entity.getPrice());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public ServicesEntity get(Integer id){
        return serviceRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Service not found"));
    }
//--------------------------------------------------------------
}