package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.proj.mvcjdbc.repository.Util.loadQuery;

@Repository
public class ShelterRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String query1;
    private final String query2;
    private final String query3;

    @Autowired
    public ShelterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query1 = loadQuery("/sql/insert_shelters.sql");
        this.query2 = loadQuery("/sql/update_shelters.sql");
        this.query3 = loadQuery("/sql/delete_shelters.sql");
    }

    public void addShelter(Shelter shelter) {
        jdbcTemplate.update(query1,
                shelter.name(),
                shelter.phone(),
                shelter.internalPhone(),
                shelter.email(),
                shelter.owner(),
                shelter.status());
    }

    public void updateShelter(int id, Shelter shelter) {
        jdbcTemplate.update(query2,
                shelter.name(),
                shelter.phone(),
                shelter.internalPhone(),
                shelter.email(),
                shelter.owner(),
                shelter.status(),
                id);
    }

    public void deleteShelter(int id) {
        jdbcTemplate.update(query3, id);
    }
}
