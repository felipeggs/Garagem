package com.felipegabriel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.dao.AbstractDao;
import com.felipegabriel.dao.MoradorDaoImpl;
import com.felipegabriel.model.Morador;

@Service
public class MoradorService extends AbstractService<Morador>{
	
	@Autowired
	MoradorDaoImpl dao;

	@Override
	public AbstractDao<Morador> getDao() {
		return dao;
	}
	
	public List<Morador> pesquisarMorador(String nome) throws Exception{
		return dao.pesquisarMorador(nome);
	}

}
