package com.felipegabriel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegabriel.model.Veiculo;
import com.felipegabriel.service.VeiculoService;

@RestController
@RequestMapping("Veiculo")
@CrossOrigin(value = "*")
public class VeiculoRest {
	
	@Autowired
	VeiculoService veiculoService;
	
	@PostMapping
	public Veiculo inserir(@RequestBody Veiculo veiculo) throws Exception{
		return veiculoService.inserir(veiculo);
	}
	
	@PutMapping
	public Veiculo alterar(@RequestBody Veiculo veiculo) throws Exception{
		return veiculoService.alterar(veiculo);
	}
	
	@DeleteMapping(path="/{id}")
	public boolean excluir(@PathVariable("id") Long id) throws Exception{
		Veiculo veiculo = new Veiculo();
		veiculo.setId(id);
		return veiculoService.excluir(veiculo);
	}
	
	@GetMapping(path="/{id}")
	public Veiculo buscarPorCodigo(@PathVariable("id") Long id)throws Exception{
		return veiculoService.buscarPorCodigo(id);
	}

}
