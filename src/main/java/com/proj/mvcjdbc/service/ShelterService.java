package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.Shelter;
import com.proj.mvcjdbc.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {

    private final ShelterRepository shelterRepo;

    @Autowired
    ShelterService(ShelterRepository shelterRepo){
        this.shelterRepo = shelterRepo;
    }

    public void addShelter(Shelter shelter) {
        shelterRepo.addShelter(shelter);
    }

    public void updateShelter(int id, Shelter shelter) {
        shelterRepo.updateShelter(id, shelter);
    }

    public void deleteShelter(int id) {
        shelterRepo.deleteShelter(id);
    }
}
