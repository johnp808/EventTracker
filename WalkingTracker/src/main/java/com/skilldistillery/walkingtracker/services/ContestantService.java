package com.skilldistillery.walkingtracker.services;

import java.util.List;

import com.skilldistillery.walkingtracker.entities.Contestant;

public interface ContestantService {
	
	List<Contestant> getAllContestants();
	Contestant findById(int contestantId);
	Contestant create(Contestant contestant);
	boolean deleteById(int contestantId);
	Contestant update(int contestantId, Contestant contestant);
}
