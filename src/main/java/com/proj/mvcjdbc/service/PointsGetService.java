package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Shelter;
import com.proj.mvcjdbc.repository.GetPointsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsGetService {

    private final GetPointsRepository pointsRepository;

    @Autowired
    public PointsGetService(GetPointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    public List<Peak> getPeaks() {
        return pointsRepository.getPeaks();
    }

    public List<Shelter> getUserShelters() {
        return pointsRepository.getUserShelter();
    }

    public List<Shelter> getAdminShelters() {
        return pointsRepository.getAdminShelter();
    }
}