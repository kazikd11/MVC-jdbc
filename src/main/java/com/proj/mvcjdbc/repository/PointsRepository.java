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
public class PointsRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PointsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Peak> getPeaks() {
        String query;
        try {
            query = new String(Objects.requireNonNull(this.getClass().getResourceAsStream("/sql/select_peaks.sql")).readAllBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        return jdbcTemplate.query(query, (rs, rowNum) -> new Peak(rs.getInt("id"), rs.getString("name"), rs.getInt("height")));
    }

    public List<Shelter> getUserShelter() {
        String query;
        try{
            query = new String(Objects.requireNonNull(this.getClass().getResourceAsStream("/sql/select_user_shelter.sql")).readAllBytes());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        return jdbcTemplate.query(query, (rs, rowNum) ->
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
        String query;
        try{
            query = new String(Objects.requireNonNull(this.getClass().getResourceAsStream("/sql/select_admin_shelter.sql")).readAllBytes());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        return jdbcTemplate.query(query, (rs, rowNum) ->
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
