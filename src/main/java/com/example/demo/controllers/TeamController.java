package com.example.demo.controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestDTO;
import com.example.demo.entities.Teams;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.MatchService;
import com.example.demo.service.TeamService;

@RestController
@RequestMapping("/api/v1")

public class TeamController {

	@Autowired
	private MatchService matchService;

	@Autowired
	private TeamService teamService;

	@GetMapping("/teams")
	public ResponseEntity<List<Teams>> getTeams() throws EntityNotFoundException {
		try {
			final List<Teams> list = getTeamService().findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/team/{id}")
	public ResponseEntity<Teams> updateMatch(
			@PathVariable @NotBlank(message = "Team id is required field") final Long id,
			@RequestBody RequestDTO requestDTO) throws EntityNotFoundException {
		boolean isUpdated;
		try {
			isUpdated = getTeamService().update(id, requestDTO.getName());

			if (!isUpdated) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			final Teams teams = getTeamService().findById(id);
			return new ResponseEntity<>(teams, HttpStatus.OK);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	public MatchService getMatchService() {
		return matchService;
	}

	public TeamService getTeamService() {
		return teamService;
	}

}
