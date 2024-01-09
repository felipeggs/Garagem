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
		insert.setColumnNames(Arrays.asList("cor, plca, marca"));
		insert.setTableName("veiculo");
		insert.setGeneratedKeyName("id");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("cor", obj.getCor());
		param.addValue("placa", obj.getPlaca());
		param.addValue("marca", obj.getMarca());
		
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;

	}

	@Override
	public Veiculo alterar(Veiculo obj) throws Exception {
		String sql = "update Veiculo set cor=?, placa=?, marca=? where id=?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Veiculo obj) throws Exception {
		String sql = "delete from Veiculo where id=?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Veiculo buscarPorId(Long id) throws Exception {
		String sql = "Select * from Veiculo where id=?";
		return jdbc.queryForObject(sql, new VeiculoRowMapper(), id);
	}


}
