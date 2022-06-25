package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Matches;
import com.example.demo.entities.TeamMatchOV;

public interface MatchDao {

	public Matches create(final Matches match) throws Exception;

	public Matches findById(final Long id) throws Exception;

	public List<TeamMatchOV> findAllWinners() throws Exception;

	public List<TeamMatchOV> findAllUpcommingMatchsByTeamId(long id) throws Exception;

	public List<TeamMatchOV> findAllMatchsByTeamId(long id) throws Exception;

	public int delete(long id) throws Exception;

	public int update(long id, Date startDate) throws Exception;

}
