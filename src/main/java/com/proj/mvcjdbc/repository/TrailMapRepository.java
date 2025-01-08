package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.TrailPoint;
import com.proj.mvcjdbc.model.TrailPointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrailMapRepository {

    private JdbcTemplate jdbcTemplate;
    private final String query1;

    @Autowired
    public TrailMapRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query1 = Util.loadQuery("/sql/select_map.sql");
    }

    public List<TrailPoint> getTrails() {
        return jdbcTemplate.query(query1, (rs, rowNum) -> new TrailPoint(
                rs.getInt("point1_id"),
                rs.getInt("point2_id"),
                rs.getInt("trail_id"),
                rs.getInt("travel_time"),
                rs.getString("color")
        ));
    }

}
