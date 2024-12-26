package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(User users){
        int res = -999;
        try{
            String query = "INSERT INTO USERS(name, city, gender, email) VALUES(?,?,?,?)";
            res = jdbcTemplate.update(query, users.getName(), users.getCity(), users.getGender(), users.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int update(User users){
        int res = -999;
        try{
            String query = "UPDATE USERS SET name = ?, city = ?, gender = ? where email = ?";
            res = jdbcTemplate.update(query, users.getName(), users.getCity(), users.getGender(), users.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int deleteByEmail(String email){
        int res = -999;
        try{
            String query = "DELETE FROM USERS where email = ?";
            res = jdbcTemplate.update(query, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public User getUserByEmail(String email){
        User usre = null;
        try{
            String query = "SELECT * from USERS where email = ?";
            usre = jdbcTemplate.queryForObject(query, new UserRowMapper(), email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usre;
    }

    public List<User> getUsersByEmail(String email){
        List<User> usres = null;
        try{
            String query = "SELECT * from USERS where email = ?";
            usres = jdbcTemplate.query(query, new UserRowMapper(), email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usres;
    }

    private static final class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new User(rs.getString("name"), rs.getString("email"), rs.getString("city"), rs.getString("gender") );
        }
    }
}
