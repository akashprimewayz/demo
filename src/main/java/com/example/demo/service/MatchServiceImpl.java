package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MatchDao;
import com.example.demo.dto.MatchDTO;
import com.example.demo.entities.Matches;
import com.example.demo.entities.TeamMatchOV;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;

	@Override
	public Matches create(MatchDTO match) throws Exception {
		final Matches matches = new Matches();

		matches.setHomeTeam(match.getHomeTeam());
		matches.setAwayTeam(match.getAwayTeam());
		matches.setStartDate(match.getStartDate());
		matches.setHomeTeamScore(match.getHomeTeamScore());
		matches.setAwayTeamScore(match.getAwayTeamScore());

		return getMatchDao().create(matches);
	}

	@Override
	public List<TeamMatchOV> findAllWinners() throws Exception {
		return getMatchDao().findAllWinners();
	}

	@Override
	public List<TeamMatchOV> findAllUpcommingMatchsByTeamId(long id) throws Exception {
		return getMatchDao().findAllUpcommingMatchsByTeamId(id);
	}

	@Override
	public List<TeamMatchOV> findAllMatchsByTeamId(long id) throws Exception {
		return getMatchDao().findAllMatchsByTeamId(id);
	}

	@Override
	public boolean delete(long id) throws Exception {
		final int rowCount = getMatchDao().delete(id);
		if (rowCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(long id, Date startDate) throws Exception {
		final int rowCount = getMatchDao().update(id, startDate);
		if (rowCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Matches findById(Long id) throws Exception {
		return getMatchDao().findById(id);
	}

	public MatchDao getMatchDao() {
		return matchDao;
	}

	public void setMatchDao(MatchDao matchDao) {
		this.matchDao = matchDao;
	}

}
