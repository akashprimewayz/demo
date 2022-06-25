package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MatchDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Home team id is required field")
	private Long homeTeam;
	@Valid
	@NotNull(message = "Away team id is required field")
	private Long awayTeam;

	private int homeTeamScore;
	private int awayTeamScore;

	@NotNull(message = "Start date is required field")
	private Date startDate;

	public Long getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Long homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Long getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Long awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
