package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.TrailPoint;
import com.proj.mvcjdbc.model.TrailPointDTO;
import com.proj.mvcjdbc.repository.TrailMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrailMapService {

    private final TrailMapRepository trailMapRepository;

    public TrailMapService(TrailMapRepository trailMapRepository) {
        this.trailMapRepository = trailMapRepository;
    }

    public Map<Integer, List<Integer>> getTrails() {
        List<TrailPoint> segments = trailMapRepository.getTrails();
        Map<Integer, List<Integer>> trails = new HashMap<>();

        for (TrailPoint segment : segments) {
            trails.computeIfAbsent(segment.trailId(), k -> new ArrayList<>());
            if (!trails.get(segment.trailId()).contains(segment.point1Id())) {
                trails.get(segment.trailId()).add(segment.point1Id());
            }
            if (!trails.get(segment.trailId()).contains(segment.point2Id())) {
                trails.get(segment.trailId()).add(segment.point2Id());
            }
        }

        return trails;
    }
}
