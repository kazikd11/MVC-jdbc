package com.proj.mvcjdbc.repository;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Point;
import com.proj.mvcjdbc.model.PointTime;
import com.proj.mvcjdbc.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.proj.mvcjdbc.repository.Util.loadQuery;

@Repository
public class GetPointsRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String query1;
    private final String query2;
    private final String query3;
    private final String query4;

    @Autowired
    public GetPointsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query1 = loadQuery("/sql/select_peaks.sql");
        this.query2 = loadQuery("/sql/select_user_shelter.sql");
        this.query3 = loadQuery("/sql/select_admin_shelter.sql");
        this.query4 = loadQuery("/sql/find_path.sql");
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

    public List<PointTime> getPath(int id1, int id2) {
        return jdbcTemplate.query(query4, ps -> {
            ps.setInt(1, id1);
            ps.setInt(2, id2);
        }, (rs, rowNum) -> {
            if (rowNum == 1) {
                return new PointTime(rs.getInt("point_id"),rs.getInt("total_time"));
            }
            else {
                return new PointTime(rs.getInt("point_id"),0);
            }
        });
    }

}