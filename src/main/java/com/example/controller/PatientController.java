package com.example.controller;

import com.example.dto.DoctorDTO;
import com.example.dto.PatientsDTO;
import com.example.service.DoctorService;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    //      1. create
    @PostMapping(value = "")
    public ResponseEntity<PatientsDTO> create(@RequestBody PatientsDTO dto,
                                              @RequestParam(name = "clinicId") int clinicId) {
        return ResponseEntity.ok().body(patientService.create(dto, clinicId));
    }

    //      2. get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientsDTO> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(patientService.getById(id));
    }

    //      3. get all
    @GetMapping(value = "")
    public ResponseEntity<List<PatientsDTO>> getAll() {
        return ResponseEntity.ok().body(patientService.getAll());
    }

    //      4. update clinic
    @PutMapping(value = "/{id}")
    public ResponseEntity<Boolean> update(@RequestBody PatientsDTO dto,
                                          @PathVariable String id) {
        return ResponseEntity.ok().body(patientService.update(dto, id));
    }

    //      5. delete clinic
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(patientService.delete(id));
    }

    //      6. get pagination
    @GetMapping(value = "/pagination")
    public ResponseEntity<Page<PatientsDTO>> pagination(@RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size) {
        return ResponseEntity.ok().body(patientService.pagination(page, size));
    }
}

