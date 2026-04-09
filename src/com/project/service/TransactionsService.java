package com.project.service;

import com.project.config.DBConnectionPool;
import com.project.model.User;
import com.project.model.Order;

import java.sql.*;

public class TransactionsService {

    public void createUserWithOrder(User user, Order order) {

        Connection con = null;

        try {
            con = DBConnectionPool.getConnection();
            con.setAutoCommit(false);

       
            PreparedStatement ps1 = con.prepareStatement(
                "INSERT INTO users(name, email, password) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps1.setString(1, user.getName());
            ps1.setString(2, user.getEmail());
            ps1.setString(3, user.getPassword());

            ps1.executeUpdate();

            
            ResultSet rs = ps1.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }

           
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO orders(user_id, product_name, amount) VALUES (?, ?, ?)"
            );

            ps2.setInt(1, userId);
            ps2.setString(2, order.getProductName());
            ps2.setDouble(3, order.getAmount());

            ps2.executeUpdate();

            con.commit(); 

            System.out.println("Transaction Successful!");

        } catch (Exception e) {

            try {
                if (con != null) con.rollback(); 
                System.out.println("Transaction Failed! Rolled back.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}