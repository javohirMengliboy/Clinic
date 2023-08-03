package com.example.controller;

import com.example.dto.ClinicDTO;
import com.example.entity.ClinicEntity;
import com.example.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    //      1. create
    @PostMapping(value = "")
    public ResponseEntity<ClinicDTO> create(@RequestBody ClinicDTO dto){
        return ResponseEntity.ok().body(clinicService.create(dto));
    }

    //      2. get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClinicDTO> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(clinicService.getById(id));
    }

    //      3. get all
    @GetMapping(value = "")
    public ResponseEntity<List<ClinicDTO>> getAll(){
        return ResponseEntity.ok().body(clinicService.getAll());
    }
    //      4. update clinic
    @PutMapping(value = "/{id}")
    public ResponseEntity<Boolean> update(@RequestBody ClinicDTO dto,
                                            @PathVariable int id){
        return ResponseEntity.ok().body(clinicService.update(dto, id));
    }

    //      5. delete clinic
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return ResponseEntity.ok().body(clinicService.delete(id));
    }

    //      6. get pagination
    @GetMapping(value = "/pagination")
    public ResponseEntity<Page<ClinicDTO>> pagination(@RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size){
        return ResponseEntity.ok().body(clinicService.pagination(page, size));
    }
}
