package com.project.dao;

import com.project.model.User;
import com.project.config.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    
    public void addUser(User user) {
        String sql = "INSERT INTO users(id,name,email,password) VALUES(?,?,?,?)";
                try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public User getUser(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        User user = null;

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(); // needs default constructor
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // UPDATE
    public void updateUser(User user) {
        String sql = "UPDATE users SET name=?,email=?,password=? WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}