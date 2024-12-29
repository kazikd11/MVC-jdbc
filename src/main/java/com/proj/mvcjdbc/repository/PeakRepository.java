package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.Peak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.proj.mvcjdbc.repository.Util.loadQuery;

@Repository
public class PeakRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String query1;
    private final String query2;
    private final String query3;

    @Autowired
    public PeakRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query1 = loadQuery("/sql/insert_peaks.sql");
        this.query2 = loadQuery("/sql/update_peaks.sql");
        this.query3 = loadQuery("/sql/delete_peaks.sql");
    }

    public void addPeak(Peak peak) {
        jdbcTemplate.update(query1,
                peak.name(),
                peak.height()
        );
    }

    public void updatePeak(int id, Peak peak) {
        jdbcTemplate.update(query2,
                peak.name(),
                peak.height(),
                id
        );
    }

    public void deletePeak(int id) {
        jdbcTemplate.update(query3, id);
    }
}
