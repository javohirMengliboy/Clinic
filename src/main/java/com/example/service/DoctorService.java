package com.example.service;

import com.example.dto.ClinicDTO;
import com.example.dto.DoctorDTO;
import com.example.dto.ScheduleDTO;
import com.example.entity.ClinicEntity;
import com.example.entity.ClinicsAndDoctorsEntity;
import com.example.entity.DoctorEntity;
import com.example.entity.ScheduleEntity;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import com.example.mapper.DoctorMapper;
import com.example.repository.ClinicRepository;
import com.example.repository.ClinicsAndDoctorsRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.ScheduleRepository;
import com.example.util.ProfileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClinicsAndDoctorsRepository clinicsAndDoctorsRepository;


    //      1. create
    public DoctorDTO create(DoctorDTO dto, Integer clinicId) {
        Optional<DoctorEntity> doctorEntity = doctorRepository.findByPhone(dto.getPhone());
        if (doctorEntity.isPresent()){
            throw new AppBadRequestException("This phone already exists");
        }
        ProfileUtil.check(dto);
        DoctorEntity entity = new DoctorEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setAge(dto.getAge());
        entity.setImageId(dto.getImageId());
        entity.setSpecialty(dto.getSpecialty());
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setExperience(dto.getExperience());
        doctorRepository.save(entity);

        ClinicsAndDoctorsEntity clinicsAndDoctorsEntity = new ClinicsAndDoctorsEntity();
        clinicsAndDoctorsEntity.setClinicId(clinicId);
        clinicsAndDoctorsEntity.setDoctorId(entity.getId());
        clinicsAndDoctorsRepository.save(clinicsAndDoctorsEntity);

        for (ScheduleDTO scheduleDTO : dto.getScheduleList()){
            ScheduleEntity scheduleEntity = new ScheduleEntity();
            scheduleEntity.setWeekDay(scheduleDTO.getWeekDay());
            scheduleEntity.setStartWorkingTime(scheduleDTO.getStartWorkingTime());
            scheduleEntity.setEndWorkingTime(scheduleDTO.getEndWorkingTime());
            scheduleEntity.setDoctorId(entity.getId());
            scheduleRepository.save(scheduleEntity);
        }

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    //      2. get by id
    public DoctorDTO getById(String id) {
        return doctorRepository.findById(id).map(this::toDTO).orElseThrow(()->  new ItemNotFoundException("Doctor not found"));
    }

    //      3. get all
    public List<DoctorDTO> getAll() {
        List<DoctorEntity> entityList =  doctorRepository.findAllBy();
        if (entityList.isEmpty()){
            throw new ItemNotFoundException("Clinic not found");
        }
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<DoctorMapper> getDoctorEntitiesBySpecialty(String specialty) {
        List<DoctorMapper> mapperList =  doctorRepository.getDoctorEntitiesBySpecialty(specialty);
        if (mapperList.isEmpty()){
            throw new ItemNotFoundException("Clinic not found");
        }
        mapperList.forEach(e->{
            List<String> list = scheduleRepository.getWorkingDaysByDoctorId(e.getId());
            e.setWorkingDays(list);
        });
        return mapperList;
    }

    public List<DoctorMapper> search(String value) {
        value = ("%"+value+"%").toLowerCase();
        List<DoctorMapper> mapperList =  doctorRepository.search(value);
        if (mapperList.isEmpty()){
            throw new ItemNotFoundException("Doctor not found");
        }
        mapperList.forEach(e->{
            List<String> list = scheduleRepository.getWorkingDaysByDoctorId(e.getId());
            e.setWorkingDays(list);
        });
        return mapperList;
    }

    //      4. update clinic
    public Boolean update(DoctorDTO dto, String id) {
        ProfileUtil.check(dto);
        DoctorEntity entity = doctorRepository.findById(id).get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setAge(dto.getAge());
        entity.setSpecialty(dto.getSpecialty());
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setExperience(dto.getExperience());
        doctorRepository.save(entity);
        return true;
    }

    //      5. delete clinic
    public Boolean delete(String id) {
        doctorRepository.deleteById(id);
        return true;
    }

    //      6. pagination
    public Page<DoctorDTO> pagination(int page, int size) {
        Pageable pageable = PageRequest.of((page-1), size, Sort.by("name"));
        return doctorRepository.findAllDoctor(pageable).map(this::toDTO);
    }


    // ---------------------------------------------------------
    private DoctorDTO toDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setPhone(entity.getPhone());
        dto.setAge(entity.getAge());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setSpecialty(entity.getSpecialty());
        dto.setScheduleList(entity.getScheduleEntityList().stream().map(this::scheduleToDTO).collect(Collectors.toList()));
        return dto;
    }

    public ScheduleDTO scheduleToDTO(ScheduleEntity entity){
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(entity.getId());
        dto.setDoctorId(entity.getDoctorId());
        dto.setWeekDay(entity.getWeekDay());
        dto.setStartWorkingTime(entity.getStartWorkingTime());
        dto.setEndWorkingTime(entity.getEndWorkingTime());
        return dto;
    }
    //--------------------------------------------------------------
}
