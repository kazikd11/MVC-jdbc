package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.TrailPointDTO;
import com.proj.mvcjdbc.service.TrailMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trails")
public class TrailMapController {

    private final TrailMapService trailMapService;

    public TrailMapController(TrailMapService trailMapService) {
        this.trailMapService = trailMapService;
    }

    @GetMapping
    public Map<Integer, List<Integer>> getTrails() {
        return trailMapService.getTrails();
    }
}
