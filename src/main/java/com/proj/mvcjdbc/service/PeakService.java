package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.repository.PeakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeakService {

    private final PeakRepository peakRepo;

    @Autowired
    PeakService(PeakRepository peakRepo){
        this.peakRepo = peakRepo;
    }

    public void addPeak(Peak peak) {
        peakRepo.addPeak(peak);
    }

    public void updatePeak(int id, Peak peak) {
        peakRepo.updatePeak(id, peak);
    }

    public void deletePeak(int id) {
        peakRepo.deletePeak(id);
    }
}
