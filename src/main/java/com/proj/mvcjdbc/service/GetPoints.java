package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.entity.PeakEntity;
import com.proj.mvcjdbc.model.mvc.Peak;
import com.proj.mvcjdbc.model.mvc.Shelter;
import com.proj.mvcjdbc.repository.PeakRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetPoints {

    private final PeakRepository peakRepository;

    @Autowired
    public GetPoints(PeakRepository peakRepository) {
        this.peakRepository = peakRepository;
    }

    public List<Peak> getPeaks() {
        return peakRepository.getPeaks()
                .stream()
                .map(peakEntity -> new Peak(peakEntity.id(), peakEntity.name(), peakEntity.height()))
                .toList();
    }

    public static List<Shelter> getShelters(){
        List<Shelter> shelters = new ArrayList<>();
        shelters.add(new Shelter(1, "Shelter 1", 1000));
        shelters.add(new Shelter(2, "Shelter 2", 2000));
        shelters.add(new Shelter(3, "Shelter 3", 3000));
        return shelters;
    }
}
