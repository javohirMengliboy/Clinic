package com.example.service;

import com.example.dto.PatientsDTO;
import com.example.entity.PatientEntity;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import com.example.repository.ClinicsAndDoctorsRepository;
import com.example.repository.PatientRepository;
import com.example.repository.ScheduleRepository;
import com.example.util.ProfileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClinicsAndDoctorsRepository clinicsAndDoctorsRepository;


    //      1. create
    public PatientsDTO create(PatientsDTO dto, Integer clinicId) {
        Optional<PatientEntity> doctorEntity = patientRepository.findByPhone(dto.getPhone());
        if (doctorEntity.isPresent()){
            throw new AppBadRequestException("This phone already exists");
        }
        ProfileUtil.check(dto);
        PatientEntity entity = new PatientEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setAge(dto.getAge());
        patientRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return null;
    }

    //      2. get by id
    public PatientsDTO getById(String id) {
        return patientRepository.findById(id).map(this::toDTO).orElseThrow(()->  new ItemNotFoundException("Clinic not found"));
    }

    //      3. get all
    public List<PatientsDTO> getAll() {
        List<PatientEntity> entityList =  patientRepository.findAllBy();
        if (entityList.isEmpty()){
            throw new ItemNotFoundException("Clinic not found");
        }
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    //      4. update clinic
    public Boolean update(PatientsDTO dto, String id) {
        ProfileUtil.check(dto);
        PatientEntity entity = patientRepository.findById(id).get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setAge(dto.getAge());
        patientRepository.save(entity);
        return true;
    }

    //      5. delete clinic
    public Boolean delete(String id) {
        patientRepository.deleteById(id);
        return true;
    }

    //      6. pagination
    public Page<PatientsDTO> pagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return patientRepository.findAllPatient(pageable).map(this::toDTO);
    }


    // ---------------------------------------------------------
    private PatientsDTO toDTO(PatientEntity entity) {
        PatientsDTO dto = new PatientsDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setPhone(entity.getPhone());
        dto.setAge(entity.getAge());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
    //--------------------------------------------------------------
}
