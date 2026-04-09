package com.project;

import com.project.dao.*;
import com.project.model.*;
import com.project.service.*;


public class MainApp {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAOImpl();

        // CRUD
        User user = new User();
        user.setName("Lokesh");
        user.setEmail("lokesh@gmail.com");
        user.setPassword("123");

        userDAO.addUser(user);

        User u = userDAO.getUser(1);
        System.out.println(u.getName());

        // Transaction
        TransactionsService service = new TransactionsService();

        Order order = new Order();
        order.setProductName("Laptop");
        order.setAmount(50000);

        service.createUserWithOrder(user, order);
        
        
    }
}