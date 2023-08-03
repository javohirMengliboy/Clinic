package com.example.controller;

import com.example.dto.RoomDTO;
import com.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping(value = "/{clinicId}")
    public ResponseEntity<List<RoomDTO>> create(@PathVariable("clinicId") int clinicId,
                                               @RequestParam("floor") int floor,
                                               @RequestParam("numberOfRooms") int numberOfRooms){
        return ResponseEntity.ok().body(roomService.create(clinicId,floor,numberOfRooms));
    }

    @GetMapping(value = "/{clinicId}")
    public ResponseEntity<List<RoomDTO>> getAllByClinicId(@PathVariable("clinicId") int clinicId){
        return ResponseEntity.ok().body(roomService.getAllByClinicId(clinicId));
    }

    @GetMapping(value = "get_by_order_number")
    public ResponseEntity<RoomDTO> getRoomByOrderNumber(@RequestParam("orderNumber") int orderNumber){
        return ResponseEntity.ok().body(roomService.getRoomByOrderNumber(orderNumber));
    }
}
