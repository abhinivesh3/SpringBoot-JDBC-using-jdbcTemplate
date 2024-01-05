package com.abhi.SpringJDBC.repository;

import com.abhi.SpringJDBC.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AlienRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String sql = "insert into alien (id,name,tech) values(?,?,?)";
        int row=jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getTech());
        System.out.println(row);
    }

    public List<Alien> findAll() {
        String sql ="select * from alien";
        //function interface
//        RowMapper<Alien> rowMapper = new RowMapper<Alien>() {
//            @Override
//            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Alien alien = new Alien();
//                alien.setId(rs.getInt(1));
//                alien.setName(rs.getString(2));
//                alien.setTech(rs.getString(3));
//                return alien;
//            }
//        };
        //lambda
//        RowMapper<Alien> rowMapper = ( rs, rowNum) -> {
//                Alien alien = new Alien();
//                alien.setId(rs.getInt(1));
//                alien.setName(rs.getString(2));
//                alien.setTech(rs.getString(3));
//                return alien;
//            }
//        };
//        List<Alien> result = jdbcTemplate.query(sql,rowMapper);

        List<Alien> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));
                return alien;
        });
         return result;
    }
}
