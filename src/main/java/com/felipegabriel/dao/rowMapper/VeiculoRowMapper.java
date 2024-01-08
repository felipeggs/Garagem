package com.felipegabriel.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.felipegabriel.model.Veiculo;

public class VeiculoRowMapper implements RowMapper<Veiculo>{

	@Override
	public Veiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Veiculo veiculo = new Veiculo();
		
		veiculo.setId(rs.getLong("id"));
		veiculo.setCor(rs.getString("cor"));
		veiculo.setMarca(rs.getString("marca"));
		veiculo.setPlaca(rs.getString("placa"));
		return veiculo;
	}
	

}
