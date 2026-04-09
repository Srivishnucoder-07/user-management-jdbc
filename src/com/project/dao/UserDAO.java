package com.project.dao;

import com.project.model.User;

public interface UserDAO {
 
    void updateUser(User user);
    void deleteUser(int id);
	void addUser(User user);
	User getUser(int i);
	
}
