package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MatchDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.entities.Matches;
import com.example.demo.entities.TeamMatchOV;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.MatchService;
import com.example.demo.service.TeamService;

@RestController
@RequestMapping("/api/v1")
public class MatchController {

	@Autowired
	private MatchService matchService;

	@Autowired
	private TeamService teamService;

	@PostMapping("/match")
	public ResponseEntity<Matches> createMatch(@Valid @RequestBody MatchDTO matchDTO) throws EntityNotFoundException {
		try {
			final Matches matches = getMatchService().create(matchDTO);
			return new ResponseEntity<>(matches, HttpStatus.OK);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/winners")
	public ResponseEntity<List<TeamMatchOV>> getWinners() throws EntityNotFoundException {
		try {
			final List<TeamMatchOV> list = getMatchService().findAllWinners();
			return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/matches/upcomming/{id}")
	public ResponseEntity<List<TeamMatchOV>> getUpcommingMatches(
			@PathVariable @NotNull(message = "Team id is required field") final Long id)
			throws EntityNotFoundException {
		try {
			final List<TeamMatchOV> list = getMatchService().findAllUpcommingMatchsByTeamId(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/matches/all/{id}")
	public ResponseEntity<List<TeamMatchOV>> getAllMatches(
			@PathVariable @NotNull(message = "Team id is required field") final Long id)
			throws EntityNotFoundException {
		try {
			final List<TeamMatchOV> list = getMatchService().findAllMatchsByTeamId(id);

			return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/match/{id}")
	public ResponseEntity<Long> deleteMatch(@PathVariable @NotNull(message = "Team id is required field") final Long id)
			throws EntityNotFoundException {
		boolean isRemoved;
		try {
			isRemoved = getMatchService().delete(id);
			if (!isRemoved) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/match/{id}")
	public ResponseEntity<Matches> updateMatch(
			@PathVariable @NotBlank(message = "Team id is required field") final Long id,
			@RequestBody RequestDTO requestDTO) throws EntityNotFoundException {
		boolean isUpdated;
		try {
			isUpdated = getMatchService().update(id, requestDTO.getStartDate());
			if (!isUpdated) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			final Matches matches = getMatchService().findById(id);
			return new ResponseEntity<>(matches, HttpStatus.OK);
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
