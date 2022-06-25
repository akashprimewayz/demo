package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class RequestDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date startDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
