package com.felipegabriel.dao;

import java.util.Arrays;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.felipegabriel.dao.rowMapper.VeiculoRowMapper;
import com.felipegabriel.model.Veiculo;

@Repository
public class VeiculoDaoImpl extends AbstractDaoImpl<Veiculo>{

	@Override
	public Veiculo inserir(Veiculo obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("Cor", "Placa","Marca"));
		insert.setTableName("Veiculo");
		insert.setGeneratedKeyName("Id");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("Cor", obj.getCor());
		param.addValue("Placa", obj.getPlaca());
		param.addValue("Marca", obj.getMarca());
		
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;

	}

	@Override
	public Veiculo alterar(Veiculo obj) throws Exception {
		String sql = "update Veiculo set Cor=?, Placa=?, Marca=? where Id=?";
		int result = jdbc.update(sql, obj.getCor(),obj.getPlaca(), obj.getMarca(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Veiculo obj) throws Exception {
		String sql = "delete from Veiculo where Id=?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Veiculo buscarPorId(Long id) throws Exception {
		String sql = "Select * from Veiculo where Id=?";
		return jdbc.queryForObject(sql, new VeiculoRowMapper(), id);
	}


}
