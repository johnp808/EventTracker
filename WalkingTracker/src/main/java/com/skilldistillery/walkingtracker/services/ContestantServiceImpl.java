package com.skilldistillery.walkingtracker.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.walkingtracker.entities.Contestant;
import com.skilldistillery.walkingtracker.repositories.ContestantRepository;

@Service
@Transactional
public class ContestantServiceImpl implements ContestantService {
	
	@Autowired
	private ContestantRepository contestantRepo;
	
	@Override
	public List<Contestant> getAllContestants() {

		return contestantRepo.findAll();
	}
	
	@Override
	public Contestant findById(int contestantId) {
		Optional<Contestant> contestantOpt = contestantRepo.findById(contestantId);
		return contestantOpt.get();
	}

	@Override
	public Contestant create(Contestant contestant) {
		contestantRepo.saveAndFlush(contestant);
		return contestant;
	}

	@Override
	public Contestant update(int contestantId, Contestant contestant) {
		Optional<Contestant> contestantOpt = contestantRepo.findById(contestantId);
		Contestant managedContestant = null;
		if (contestantOpt.isPresent()) {
			managedContestant = contestantOpt.get();
			managedContestant.setName(contestant.getName());
			managedContestant.setGender(contestant.getGender());
			managedContestant.setAge(contestant.getAge());
			managedContestant.setContestantImage(contestant.getContestantImage());
			managedContestant.setRepresentingCity(contestant.getRepresentingCity());
			managedContestant.setRepresentingState(contestant.getRepresentingState());
			managedContestant.setEventName(contestant.getEventName());
			managedContestant.setEventDate(contestant.getEventDate());
			managedContestant.setFinishTime(contestant.getFinishTime());
			managedContestant.setPlace(contestant.getPlace());
			contestantRepo.saveAndFlush(managedContestant);
		}
		return managedContestant;
	}

	@Override
	public boolean deleteById(int contestantId) {
		boolean deleted = false;
		Optional<Contestant> contestantOpt = contestantRepo.findById(contestantId);
		if (contestantOpt.isPresent()) {
			contestantRepo.deleteById(contestantId);
			deleted = true;
		}
		return deleted;
	}

}
