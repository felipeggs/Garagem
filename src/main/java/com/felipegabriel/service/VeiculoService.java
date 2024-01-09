package com.felipegabriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.dao.AbstractDao;
import com.felipegabriel.dao.VeiculoDaoImpl;
import com.felipegabriel.model.Veiculo;

@Service
public class VeiculoService extends AbstractService<Veiculo>{
	
	@Autowired
	private VeiculoDaoImpl dao;

	@Override
	public AbstractDao<Veiculo> getDao() {
		return dao;
	}

}
