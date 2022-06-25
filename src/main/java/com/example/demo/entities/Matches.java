package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

public class Matches implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long homeTeam;
	private Long awayTeam;
	private int homeTeamScore;
	private int awayTeamScore;
	private Date startDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
