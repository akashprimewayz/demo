package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.MatchDTO;
import com.example.demo.entities.Matches;
import com.example.demo.entities.TeamMatchOV;

public interface MatchService {

	public Matches create(final MatchDTO match) throws Exception;

	public List<TeamMatchOV> findAllWinners() throws Exception;

	public List<TeamMatchOV> findAllUpcommingMatchsByTeamId(long id) throws Exception;

	public List<TeamMatchOV> findAllMatchsByTeamId(long id) throws Exception;

	public boolean delete(long id) throws Exception;

	public boolean update(long id, Date startDate) throws Exception;

	public Matches findById(final Long id) throws Exception;

}
