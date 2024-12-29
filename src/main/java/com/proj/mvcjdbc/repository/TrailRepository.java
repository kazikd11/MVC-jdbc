package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.TrailPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.proj.mvcjdbc.repository.Util.loadQuery;

@Repository
public class TrailRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String query1;
    private final String query2;
    private final String query3;

    @Autowired
    public TrailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query1 = loadQuery("/sql/insert_trail_points.sql");
        this.query2 = loadQuery("/sql/update_trail_points.sql");
        this.query3 = loadQuery("/sql/delete_trail_points.sql");
    }

    public void addTrailPoint(TrailPoint trailPoint) {
        jdbcTemplate.update(query1,
                trailPoint.point1Id(),
                trailPoint.point2Id(),
                trailPoint.trailId(),
                trailPoint.travelTime(),
                trailPoint.color()
        );
    }

    public void updateTrailPoint(TrailPoint trailPoint) {
        jdbcTemplate.update(query2,
                trailPoint.trailId(),
                trailPoint.travelTime(),
                trailPoint.color(),
                trailPoint.point1Id(),
                trailPoint.point2Id()
        );
    }

    public void deleteTrailPoint(int point1Id, int point2Id) {
        jdbcTemplate.update(query3, point1Id, point2Id);
    }
}
