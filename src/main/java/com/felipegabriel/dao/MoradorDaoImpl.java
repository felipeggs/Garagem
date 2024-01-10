package com.felipegabriel.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.felipegabriel.dao.rowMapper.MoradorRowMapper;
import com.felipegabriel.model.Morador;

@Repository
public class MoradorDaoImpl extends AbstractDaoImpl<Morador>{

	@Override
	public Morador inserir(Morador obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("Bloco", "Cpf", "Numero", "Nome", "NumGaragem"));
		insert.setTableName("Morador");
		insert.setGeneratedKeyName("Id");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("Bloco", obj.getBloco());
		param.addValue("Cpf", obj.getCpf());
		param.addValue("Numero", obj.getNumero());
		param.addValue("Nome", obj.getNome());
		param.addValue("NumGaragem", obj.getNumGaragem());
		
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;
	}

	@Override
	public Morador alterar(Morador obj) throws Exception {
		String sql = "update Morador set bloco=?, cpf=?, numero=?, nome=?, numGaragem=? where id=?";
		int result = jdbc.update(sql, obj.getBloco(), obj.getCpf(), obj.getNumero(), obj.getNome(), obj.getNumGaragem(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Morador obj) throws Exception {
		String sql = "delete from Morador where id=?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Morador buscarPorId(Long id) throws Exception {
		String sql = "select * from Morador where id=?";
		return jdbc.queryForObject(sql, new MoradorRowMapper(), id);
	}
	
	public List<Morador> pesquisarMorador(String nome) throws Exception{
		String sql = "select * from Morador where upper(nome) like ?";
		nome = "%" + nome.toUpperCase().trim() + "%";
		return jdbc.query(sql, new MoradorRowMapper(), nome);
	}

}
