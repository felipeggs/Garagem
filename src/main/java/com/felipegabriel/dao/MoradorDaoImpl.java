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
		insert.setColumnNames(Arrays.asList("nome", "numero", "cpf", "numGaragem", "bloco"));
		insert.setTableName("morador");
		insert.setGeneratedKeyName("id");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nome", obj.getNome());
		param.addValue("numero", obj.getNumero());
		param.addValue("cpf", obj.getCpf());
		param.addValue("numGaragem", obj.getNumGaragem());
		param.addValue("bloco", obj.getBloco());
		
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;
	}

	@Override
	public Morador alterar(Morador obj) throws Exception {
		String sql = "update Morador set nome=?, numero=?, cpf=?, numGaragem=?, bloco=? where id=?";
		int result = jdbc.update(sql, obj.getNome(), obj.getNumero(), obj.getCpf(), obj.getNumGaragem(), obj.getBloco());
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
