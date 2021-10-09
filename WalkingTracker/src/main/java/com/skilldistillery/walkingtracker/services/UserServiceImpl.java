package com.skilldistillery.walkingtracker.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.walkingtracker.entities.User;
import com.skilldistillery.walkingtracker.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}
	
	@Override
	public User findById(int userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.get();
	}

	@Override
	public User create(User user) {
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User update(int userId, User user) {
		Optional<User> userOpt = userRepo.findById(userId);
		User managedUser = null;
		if (userOpt.isPresent()) {
			managedUser = userOpt.get();
			managedUser.setName(user.getName());
			managedUser.setGender(user.getGender());
			managedUser.setAge(user.getAge());
			managedUser.setUserImage(user.getUserImage());
			managedUser.setCity(user.getCity());
			managedUser.setState(user.getState());
			managedUser.setWalkingDate(user.getWalkingDate());
			managedUser.setMinuteDuration(user.getMinuteDuration());
			userRepo.saveAndFlush(managedUser);
		}
		return managedUser;
	}

	@Override
	public boolean deleteById(int userId) {
		boolean deleted = false;
		Optional<User> userOpt = userRepo.findById(userId);
		if (userOpt.isPresent()) {
			userRepo.deleteById(userId);
			deleted = true;
		}
		return deleted;
	}

}
