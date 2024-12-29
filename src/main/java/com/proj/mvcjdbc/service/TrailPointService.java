package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.TrailPoint;
import com.proj.mvcjdbc.model.TrailPointDTO;
import com.proj.mvcjdbc.repository.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrailPointService {

    private final TrailRepository trailRepo;

    @Autowired
    public TrailPointService(TrailRepository trailRepo) {
        this.trailRepo = trailRepo;
    }

    @Transactional
    public void addTrailPoint(TrailPointDTO trailPointDTO) {
        var points = conv2points(trailPointDTO);

        trailRepo.addTrailPoint(points[0]);
        trailRepo.addTrailPoint(points[1]);
    }

    @Transactional
    public void updateTrailPoint(TrailPointDTO trailPointDTO) {
        var points = conv2points(trailPointDTO);

        trailRepo.updateTrailPoint(points[0]);
        trailRepo.updateTrailPoint(points[1]);
    }

    @Transactional
    public void deleteTrailPoint(int id1, int id2) {
        trailRepo.deleteTrailPoint(id1,id2);
        trailRepo.deleteTrailPoint(id2,id1);
    }



    private TrailPoint[] conv2points(TrailPointDTO trailPointDTO) {
        return new TrailPoint[]
                {
                new TrailPoint(
                trailPointDTO.point2Id(),
                trailPointDTO.point1Id(),
                trailPointDTO.trailId(),
                trailPointDTO.descendTime(),
                trailPointDTO.color())
                ,
                new TrailPoint(
                trailPointDTO.point1Id(),
                trailPointDTO.point2Id(),
                trailPointDTO.trailId(),
                trailPointDTO.ascendTime(),
                trailPointDTO.color())
                };
    }
}
