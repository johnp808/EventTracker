package com.skilldistillery.walkingtracker.services;

import java.util.List;

import com.skilldistillery.walkingtracker.entities.User;

public interface UserService {
	
	List<User> getAllUsers();
	User findById(int userId);
	User create(User user);
	boolean deleteById(int userId);
	User update(int userId, User user);
}
