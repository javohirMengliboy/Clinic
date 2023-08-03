package com.example.service;

import com.example.dto.RoomDTO;
import com.example.entity.RoomEntity;
import com.example.exp.ItemNotFoundException;
import com.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> create(int clinicId, int floor, int numberOfRooms) {
        List<RoomDTO> dtoList = new ArrayList<>();
        int orderNumber = 1;
        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= numberOfRooms/floor; j++) {
                RoomEntity entity = new RoomEntity();
                entity.setOrderNumber(orderNumber++);
                entity.setClinicId(clinicId);
                entity.setFloorNumber(i);
                roomRepository.save(entity);
                dtoList.add(toDTO(entity));
            }
        }
        return dtoList;
    }

    public List<RoomDTO> getAllByClinicId(int clinicId) {
        List<RoomEntity> entityList = roomRepository.findAllByClinicId(clinicId);
        if (entityList.isEmpty()){
            throw new ItemNotFoundException("Rooms not found");
        }
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public RoomDTO getRoomByOrderNumber(Integer orderNumber){
        return toDTO(getByOrderNumber(orderNumber));
    }


    //-----------------------------------------------------------
    public RoomEntity getByOrderNumber(Integer orderNumber){
        return roomRepository.findByOrderNumber(orderNumber).orElseThrow(()->new ItemNotFoundException("Rooms not found"));
    }

    private RoomDTO toDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setClinicId(entity.getClinicId());
        dto.setFloorNumber(entity.getFloorNumber());
        dto.setIsEmpty(entity.getIsEmpty());
        return dto;
    }

}
