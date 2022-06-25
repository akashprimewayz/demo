package com.example.demo.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Matches;
import com.example.demo.entities.TeamMatchOV;
import com.example.demo.mapper.MatchMapper;
import com.example.demo.mapper.TeamMatchMapper;

@Repository
public class MatchDaoImpl implements MatchDao {

	private final String INSERT_SQL = "INSERT INTO matches (home_team_id, away_team_id,start_date)  values(:homeTeamId, :awayTeamId,:startDate)";
	private final String FETCH_SQL_UPCOMMING_MATCHES_BY_ID = "select mat.id id, t1.name home_team_name,t2.name away_team_name, mat.start_date  FROM matches mat inner join  teams t1  on mat.home_team_id=t1.id inner join  teams t2 on mat.away_team_id=t2.id where (t1.id=:id1 or t2.id=:id2) and start_date>now()";
	private final String FETCH_SQL_ALL_MATCHES_BY_ID = "SELECT mat.id id, t1.name home_team_name,t2.name away_team_name, mat.start_date  FROM matches mat inner join  teams t1  on mat.home_team_id=t1.id inner join  teams t2 on mat.away_team_id=t2.id where (t1.id=:id1 or t2.id=:id2)";

	private final String FETCH_SQL_WINNER = "SELECT" + " CASE" + " WHEN (home_team_score>away_team_score) THEN t1.name"
			+ " WHEN (away_team_score>home_team_score) THEN t2.name" + " END AS name"
			+ " FROM matches mat inner join  teams t1  on mat.home_team_id=t1.id inner join  teams t2 on mat.away_team_id=t2.id"
			+ " WHERE home_team_score is not null and away_team_score is not null and home_team_score!=away_team_score ";

	private final String DELETE_SQL_MATCH_BY_ID = "delete from matches where id=:id";
	private final String UPDATE_SQL_MATCH_BY_ID = "update matches SET start_date = :startDate where id=:id";
	private final String FETCH_SQL_MATCH_BY_ID = "select * from matches where id=:id";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Matches create(final Matches match) throws Exception {
		final KeyHolder holder = new GeneratedKeyHolder();
		final SqlParameterSource parameters = new MapSqlParameterSource().addValue("homeTeamId", match.getHomeTeam())
				.addValue("awayTeamId", match.getAwayTeam()).addValue("startDate", match.getStartDate());
		namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
		match.setId(Long.parseLong(holder.getKeys().get("id").toString()));
		return match;
	}

	@Override
	public int delete(final long id) throws Exception {
		final Map<String, Long> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.update(DELETE_SQL_MATCH_BY_ID, parameters);
	}

	@Override
	public int update(final long id, Date startDate) throws Exception {
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		parameters.put("startDate", startDate);
		return namedParameterJdbcTemplate.update(UPDATE_SQL_MATCH_BY_ID, parameters);
	}

	@Override
	public List<TeamMatchOV> findAllWinners() throws Exception {
		return namedParameterJdbcTemplate.query(FETCH_SQL_WINNER, new TeamMatchMapper());
	}

	@Override
	public List<TeamMatchOV> findAllUpcommingMatchsByTeamId(long id) throws Exception {
		final Map<String, Long> parameters = new HashMap<>();
		parameters.put("id1", id);
		parameters.put("id2", id);
		return namedParameterJdbcTemplate.query(FETCH_SQL_UPCOMMING_MATCHES_BY_ID, parameters, new TeamMatchMapper());
	}

	@Override
	public List<TeamMatchOV> findAllMatchsByTeamId(long id) throws Exception {
		final Map<String, Long> parameters = new HashMap<>();
		parameters.put("id1", id);
		parameters.put("id2", id);
		return namedParameterJdbcTemplate.query(FETCH_SQL_ALL_MATCHES_BY_ID, parameters, new TeamMatchMapper());
	}

	@Override
	public Matches findById(Long id) throws Exception {
		final Map<String, Long> parameters = new HashMap<>();
		parameters.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(FETCH_SQL_MATCH_BY_ID, parameters, new MatchMapper());
	}
}
