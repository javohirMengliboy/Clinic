package com.example.controller;

import com.example.dto.ServicesDTO;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    //      1. create
    @PostMapping(value = "")
    public ResponseEntity<ServicesDTO> create(@RequestBody ServicesDTO dto) {
        return ResponseEntity.ok().body(serviceService.create(dto));
    }

    //      2. get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ServicesDTO>> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(serviceService.getAllByClinicId(id));
    }

    //      3. update clinic
    @PutMapping(value = "/{id}")
    public ResponseEntity<Boolean> update(@RequestBody ServicesDTO dto,
                                          @PathVariable Integer id) {
        return ResponseEntity.ok().body(serviceService.update(dto, id));
    }

    //      4. delete clinic
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(serviceService.delete(id));
    }

}