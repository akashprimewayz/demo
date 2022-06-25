package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.constant.Constant;
import com.example.demo.entities.Teams;
import com.example.demo.utils.Utils;

public class TeamMapper implements RowMapper<Teams> {

	@Override
	public Teams mapRow(ResultSet rs, int rowNum) throws SQLException {

		final Teams teams = new Teams();

		teams.setId(Utils.isExist(rs, "id", Constant.ResultSetType.LONG) ? rs.getLong("id") : null);
		teams.setName(Utils.isExist(rs, "name", Constant.ResultSetType.STRING) ? rs.getString("name") : null);
		teams.setDateCreated(
				Utils.isExist(rs, "date_created", Constant.ResultSetType.DATE) ? rs.getDate("date_created") : null);
		teams.setDateModified(
				Utils.isExist(rs, "date_created", Constant.ResultSetType.DATE) ? rs.getDate("date_created") : null);

		return teams;
	}

}
