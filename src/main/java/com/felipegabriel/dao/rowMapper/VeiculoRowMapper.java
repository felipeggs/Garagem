package com.felipegabriel.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.felipegabriel.model.Veiculo;

public class VeiculoRowMapper implements RowMapper<Veiculo>{

	@Override
	public Veiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Veiculo veiculo = new Veiculo();
		
		veiculo.setId(rs.getLong("Id"));
		veiculo.setCor(rs.getString("Cor"));
		veiculo.setPlaca(rs.getString("Placa"));
		veiculo.setMarca(rs.getString("Marca"));
		return veiculo;
	}
	

}
