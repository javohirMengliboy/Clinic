package com.example.controller;

import com.example.dto.PatientsDTO;
import com.example.dto.ServiceDTO;
import com.example.service.PatientService;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    //      1. create
    @PostMapping(value = "")
    public ResponseEntity<ServiceDTO> create(@RequestBody ServiceDTO dto) {
        return ResponseEntity.ok().body(serviceService.create(dto));
    }

    //      2. get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceDTO> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(serviceService.getById(id));
    }

    //      3. get all
    @GetMapping(value = "")
    public ResponseEntity<List<ServiceDTO>> getAll() {
        return ResponseEntity.ok().body(serviceService.getAll());
    }

    //      4. update clinic
    @PutMapping(value = "/{id}")
    public ResponseEntity<Boolean> update(@RequestBody ServiceDTO dto,
                                          @PathVariable Integer id) {
        return ResponseEntity.ok().body(serviceService.update(dto, id));
    }

    //      5. delete clinic
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(serviceService.delete(id));
    }

}