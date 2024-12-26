package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.entity.PeakEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class PeakRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeakRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PeakEntity> getPeaks() {
        String query;
        try {
            query = new String(Objects.requireNonNull(this.getClass().getResourceAsStream("/sql/select_peaks.sql")).readAllBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

        return jdbcTemplate.query(query, (rs, rowNum) -> new PeakEntity(rs.getInt("id"), rs.getString("name"), rs.getInt("height")));
    }
}
