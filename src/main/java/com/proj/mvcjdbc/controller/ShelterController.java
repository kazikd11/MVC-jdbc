package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.Shelter;
import com.proj.mvcjdbc.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @PostMapping
    public void addShelter(@RequestBody Shelter shelter) {
        shelterService.addShelter(shelter);
    }

    @PutMapping
    public void updateShelter(@RequestParam int id, @RequestBody Shelter shelter) {
        shelterService.updateShelter(id, shelter);
    }

    @DeleteMapping
    public void deleteShelter(@RequestParam int id) {
        shelterService.deleteShelter(id);
    }
}
