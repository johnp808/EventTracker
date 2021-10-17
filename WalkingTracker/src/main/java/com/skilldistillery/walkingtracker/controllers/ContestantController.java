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

import com.skilldistillery.walkingtracker.entities.Contestant;
import com.skilldistillery.walkingtracker.services.ContestantService;

@RestController
@RequestMapping("api")
public class ContestantController {
	
	@Autowired
	private ContestantService contestantSvc;
	
	@GetMapping("contestants")
	public List<Contestant> contestantIndex() {
		return contestantSvc.getAllContestants();
	}
	
	@GetMapping("contestants/{contestantId}")
	public Contestant showContestant(
			@PathVariable Integer contestantId,
			HttpServletResponse res
	) {
		Contestant contestant = contestantSvc.findById(contestantId);
		if (contestant == null) {
			res.setStatus(404);
		}
		return contestant;
	}

	@PostMapping("contestants")
	public Contestant addContestant(
			@RequestBody Contestant contestant,
			HttpServletRequest req,
			HttpServletResponse res
	) {
		try {
			contestant = contestantSvc.create(contestant);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(contestant.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			contestant = null;
		}
		return contestant;
	}
	
	@PutMapping("contestants/{contestantId}")
	public Contestant replaceContestant(
			@PathVariable Integer contestantId, 
			@RequestBody Contestant contestant,
			HttpServletResponse res
	) {
		try {
			contestant = contestantSvc.update(contestantId, contestant);
			if (contestant == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			contestant = null;
		}
		return contestant;
	}
	@DeleteMapping("contestants/{contestantId}")
	public void deleteContestant(
			@PathVariable Integer contestantId,
			HttpServletResponse res
	) {
		try {
			if (contestantSvc.deleteById(contestantId)) {
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
