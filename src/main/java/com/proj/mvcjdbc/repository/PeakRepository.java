package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.Peak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PeakRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeakRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addPeak(Peak peak) {

    }

    public void updatePeak(int id, Peak peak) {
    }

    public void deletePeak(int id) {
    }
}
