package com.example.controller;

import com.example.dto.ClinicDTO;
import com.example.dto.DoctorDTO;
import com.example.entity.ClinicEntity;
import com.example.service.ClinicService;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //      1. create
    @PostMapping(value = "")
    public ResponseEntity<DoctorDTO> create(@RequestBody DoctorDTO dto,
                                            @RequestParam(name = "clinicId") int clinicId) {
        return ResponseEntity.ok().body(doctorService.create(dto, clinicId));
    }

    //      2. get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorDTO> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(doctorService.getById(id));
    }

    //      3. get all
    @GetMapping(value = "")
    public ResponseEntity<List<DoctorDTO>> getAll() {
        return ResponseEntity.ok().body(doctorService.getAll());
    }

    //      4. update clinic
    @PutMapping(value = "/{id}")
    public ResponseEntity<Boolean> update(@RequestBody DoctorDTO dto,
                                          @PathVariable String id) {
        return ResponseEntity.ok().body(doctorService.update(dto, id));
    }

    //      5. delete clinic
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(doctorService.delete(id));
    }

    //      6. get pagination
    @GetMapping(value = "")
    public ResponseEntity<Page<DoctorDTO>> pagination(@RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size) {
        return ResponseEntity.ok().body(doctorService.pagination(page, size));
    }
}