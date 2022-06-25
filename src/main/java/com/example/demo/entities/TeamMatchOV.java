package com.example.demo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamMatchOV implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long homeTeamId;
	private String homeTeamName;
	private String winner;
	private Long awayTeamId;
	private String awayTeamName;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String startDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(Long homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Long getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(Long awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
