package com.skilldistillery.walkingtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.walkingtracker.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
