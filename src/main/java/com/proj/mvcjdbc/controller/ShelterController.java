package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

//    @Autowired
//    private ShelterService shelterService;
//
//    @PostMapping
//    public void addShelter(@RequestBody Shelter shelter) {
//        shelterService.addShelter(shelter);
//    }
//
//    @PutMapping("/{id}")
//    public void updateShelter(@PathVariable int id, @RequestBody Shelter shelter) {
//        shelterService.updateShelter(id, shelter);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteShelter(@PathVariable int id) {
//        shelterService.deleteShelter(id);
//    }
}
