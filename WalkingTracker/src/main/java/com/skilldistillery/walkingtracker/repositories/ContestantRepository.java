package com.skilldistillery.walkingtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.walkingtracker.entities.Contestant;

public interface ContestantRepository extends JpaRepository<Contestant, Integer> {
	
}
