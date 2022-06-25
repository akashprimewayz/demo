package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeamDao;
import com.example.demo.entities.Teams;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;

	@Override
	public List<Teams> findAll() throws Exception {
		return getTeamDao().findAll();
	}

	@Override
	public boolean update(long id, String name) throws Exception {
		final int rowCount = getTeamDao().update(id, name);
		if (rowCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Teams findById(Long id) throws Exception {
		return getTeamDao().findById(id);
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

}
