package com.felipegabriel.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.felipegabriel.model.Morador;

public class MoradorRowMapper implements RowMapper<Morador>{

	@Override
	public Morador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Morador morador = new Morador();
		
		morador.setId(rs.getLong("id"));
		morador.setNome(rs.getString("nome"));
		morador.setCpf(rs.getString("cpf"));
		morador.setNumero(rs.getString("numero"));
		morador.setNumGaragem(rs.getString("numGarangem"));
		morador.setBloco(rs.getString("bloco"));
		return morador;
	}

}
