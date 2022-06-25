package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.constant.Constant;
import com.example.demo.entities.TeamMatchOV;
import com.example.demo.utils.Utils;

public class TeamMatchMapper implements RowMapper<TeamMatchOV> {

	@Autowired
	private Utils utils;

	@Override
	public TeamMatchOV mapRow(ResultSet rs, int rowNum) throws SQLException {

		final TeamMatchOV teamMatchVo = new TeamMatchOV();

		teamMatchVo.setId(Utils.isExist(rs, "id", Constant.ResultSetType.LONG) ? rs.getLong("id") : null);
		teamMatchVo.setHomeTeamId(
				Utils.isExist(rs, "home_team_id", Constant.ResultSetType.LONG) ? rs.getLong("home_team_id") : null);
		teamMatchVo.setHomeTeamName(
				Utils.isExist(rs, "home_team_name", Constant.ResultSetType.STRING) ? rs.getString("home_team_name")
						: null);
		teamMatchVo.setHomeTeamScore(
				Utils.isExist(rs, "home_team_score", Constant.ResultSetType.INTEGER) ? rs.getInt("home_team_score")
						: null);
		teamMatchVo.setAwayTeamId(
				Utils.isExist(rs, "away_team_id", Constant.ResultSetType.LONG) ? rs.getLong("away_team_id") : null);
		teamMatchVo.setAwayTeamName(
				Utils.isExist(rs, "away_team_name", Constant.ResultSetType.STRING) ? rs.getString("away_team_name")
						: null);
		teamMatchVo.setHomeTeamScore(
				Utils.isExist(rs, "away_team_score", Constant.ResultSetType.INTEGER) ? rs.getInt("away_team_score")
						: null);
		teamMatchVo.setStartDate(Utils.isExist(rs, "start_date", Constant.ResultSetType.TIMESTAMP)
				? Utils.dateFormatter(rs.getTimestamp("start_date"), Constant.datePattern)
				: null);
		teamMatchVo.setWinner(Utils.isExist(rs, "name", Constant.ResultSetType.STRING) ? rs.getString("name") : null);

		return teamMatchVo;
	}

	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}

}
