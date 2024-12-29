package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.TrailPointDTO;
import com.proj.mvcjdbc.service.TrailPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trail_points")
public class TrailPointsController {

    @Autowired
    private TrailPointService trailPointService;

    @PostMapping
    public void addTrailPoint(@RequestBody TrailPointDTO trailPointDTO) {
        trailPointService.addTrailPoint(trailPointDTO);
    }

    @PatchMapping
    public void updateTrailPoint(@RequestBody TrailPointDTO trailPointDTO) {
        trailPointService.updateTrailPoint(trailPointDTO);
    }

    @DeleteMapping
    public void deleteTrailPoint(@RequestParam int id1, @RequestParam int id2) {
        trailPointService.deleteTrailPoint(id1, id2);
    }
}
