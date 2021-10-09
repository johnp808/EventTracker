package com.skilldistillery.walkingtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.walkingtracker.entities.User;
import com.skilldistillery.walkingtracker.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> userIndex() {
		return userSvc.getAllUsers();
	}
	
	@GetMapping("users/{userId}")
	public User showUser(
			@PathVariable Integer userId,
			HttpServletResponse res
	) {
		User user = userSvc.findById(userId);
		if (user == null) {
			res.setStatus(404);
		}
		return user;
	}

	@PostMapping("users")
	public User addUser(
			@RequestBody User user,
			HttpServletRequest req,
			HttpServletResponse res
	) {
		try {
			user = userSvc.create(user);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(user.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			user = null;
		}
		return user;
	}
	
	@PutMapping("users/{userId}")
	public User replaceUser(
			@PathVariable Integer userId, 
			@RequestBody User user,
			HttpServletResponse res
	) {
		try {
			user = userSvc.update(userId, user);
			if (user == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			user = null;
		}
		return user;
	}
	@DeleteMapping("users/{userId}")
	public void deleteUser(
			@PathVariable Integer userId,
			HttpServletResponse res
	) {
		try {
			if (userSvc.deleteById(userId)) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
		}
	}
}
