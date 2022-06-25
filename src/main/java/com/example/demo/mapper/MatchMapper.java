package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.constant.Constant;
import com.example.demo.entities.Matches;
import com.example.demo.utils.Utils;

public class MatchMapper implements RowMapper<Matches> {

	@Override
	public Matches mapRow(ResultSet rs, int rowNum) throws SQLException {

		final Matches matches = new Matches();

		matches.setId(Utils.isExist(rs, "id", Constant.ResultSetType.LONG) ? rs.getLong("id") : null);
		matches.setHomeTeam(
				Utils.isExist(rs, "home_team_id", Constant.ResultSetType.LONG) ? rs.getLong("home_team_id") : null);
		matches.setHomeTeamScore(
				Utils.isExist(rs, "home_team_score", Constant.ResultSetType.INTEGER) ? rs.getInt("home_team_score")
						: null);
		matches.setAwayTeam(
				Utils.isExist(rs, "away_team_id", Constant.ResultSetType.LONG) ? rs.getLong("away_team_id") : null);
		matches.setHomeTeamScore(
				Utils.isExist(rs, "away_team_score", Constant.ResultSetType.INTEGER) ? rs.getInt("away_team_score")
						: null);
		matches.setStartDate(
				Utils.isExist(rs, "start_date", Constant.ResultSetType.DATE) ? rs.getDate("start_date") : null);

		return matches;
	}
}
