package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class GetPointsRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String query1;
    private final String query2;
    private final String query3;

    @Autowired
    public GetPointsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query1 = loadQuery("/sql/select_peaks.sql");
        this.query2 = loadQuery("/sql/select_user_shelter.sql");
        this.query3 = loadQuery("/sql/select_admin_shelter.sql");
    }

    private String loadQuery(String resourcePath) {
        try {
            return new String(Objects.requireNonNull(this.getClass().getResourceAsStream(resourcePath)).readAllBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public List<Peak> getPeaks() {
        return jdbcTemplate.query(query1, (rs, rowNum) ->
                new Peak(rs.getInt("id"), rs.getString("name"), rs.getInt("height"))
        );
    }

    public List<Shelter> getUserShelter() {
        return jdbcTemplate.query(query2, (rs, rowNum) ->
                new Shelter(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getBoolean("status")
                )
        );
    }

    public List<Shelter> getAdminShelter() {
        return jdbcTemplate.query(query3, (rs, rowNum) ->
                new Shelter(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getString("internal_phone_number"),
                        rs.getString("email"),
                        rs.getString("owner"),
                        rs.getBoolean("status")
                )
        );
    }
}