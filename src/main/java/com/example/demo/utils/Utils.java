package com.example.demo.utils;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.constant.Constant.ResultSetType;

public class Utils {

	public static boolean isExist(ResultSet rs, String columnName, ResultSetType type) {
		try {
			if (type.equals(ResultSetType.STRING)) {
				rs.getString(columnName);
			} else if (type.equals(ResultSetType.INTEGER)) {
				rs.getInt(columnName);
			} else if (type.equals(ResultSetType.LONG)) {
				rs.getLong(columnName);
			} else if (type.equals(ResultSetType.DATE)) {
				rs.getDate(columnName);
			} else if (type.equals(ResultSetType.TIMESTAMP)) {
				rs.getTimestamp(columnName);
			}
			return true;

		} catch (final Exception e) {
			return false;
		}

	}

	public static String dateFormatter(Date date, String pattern) {
		try {
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			final String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (final Exception e) {
			return null;
		}
	}
}
