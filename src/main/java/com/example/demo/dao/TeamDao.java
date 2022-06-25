package com.example.demo.dao;

import java.util.List;

import com.example.demo.entities.Teams;

public interface TeamDao {

	public List<Teams> findAll() throws Exception;

	public Teams findById(final Long id) throws Exception;

	public int update(long id, String name) throws Exception;
}
