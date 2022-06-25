package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Teams;
import com.example.demo.mapper.TeamMapper;

@Repository
public class TeamDaoImpl implements TeamDao {

	private final String FETCH_SQL = "select * from Teams";
	private final String UPDATE_SQL_TEAM_BY_ID = "update Teams SET name = :name where id=:id";
	private final String FETCH_SQL_TEAM_BY_ID = "select * from Teams where id=:id";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Teams> findAll() throws Exception {
		return namedParameterJdbcTemplate.query(FETCH_SQL, new TeamMapper());
	}

	@Override
	public int update(final long id, String name) throws Exception {
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		parameters.put("name", name);
		return namedParameterJdbcTemplate.update(UPDATE_SQL_TEAM_BY_ID, parameters);
	}

	@Override
	public Teams findById(Long id) throws Exception {
		final Map<String, Long> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(FETCH_SQL_TEAM_BY_ID, parameters, new TeamMapper());
	}
}
