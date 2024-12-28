package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.service.PeakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peaks")
public class PeakController {

    @Autowired
    private PeakService peakService;

    @PostMapping
    public void addPeak(@RequestBody Peak peak) {
        peakService.addPeak(peak);
    }

    @PutMapping("/{id}")
    public void updatePeak(@PathVariable int id, @RequestBody Peak peak) {
        peakService.updatePeak(id, peak);
    }

    @DeleteMapping("/{id}")
    public void deletePeak(@PathVariable int id) {
        peakService.deletePeak(id);
    }
}
