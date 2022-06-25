package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Teams;

public interface TeamService {

	public List<Teams> findAll() throws Exception;

	public Teams findById(final Long id) throws Exception;

	public boolean update(long id, String name) throws Exception;

}
