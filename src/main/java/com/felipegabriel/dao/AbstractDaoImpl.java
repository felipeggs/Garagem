package com.felipegabriel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.felipegabriel.model.BaseEntity;

public abstract class AbstractDaoImpl <T extends BaseEntity> implements AbstractDao<T>{
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	

}
