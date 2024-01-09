package com.felipegabriel.rest;

import java.util.List;

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

import com.felipegabriel.model.Morador;
import com.felipegabriel.service.MoradorService;

@RestController
@RequestMapping("morador")
@CrossOrigin(value = "*")
public class MoradorRest {
	
	@Autowired
	MoradorService moradorService;
	
	@PostMapping
	public Morador inserir(@RequestBody Morador morador) throws Exception{
		return moradorService.inserir(morador);
	}
	
	@PutMapping
	public Morador alterar(@RequestBody Morador morador) throws Exception{
		return moradorService.alterar(morador);
	}
	
	@DeleteMapping(path="/{id}")
	public boolean excluir(@PathVariable("id") Long id) throws Exception{
		Morador morador = new Morador();
		morador.setId(id);
		return moradorService.excluir(morador);
	}
	
	@GetMapping(path="/{id}")
	public Morador buscarPorCodigo(@PathVariable("id") Long id) throws Exception{
		return moradorService.buscarPorCodigo(id);
	}
	
	@PostMapping(path="pesquisaMorador")
	public List<Morador> pesquisarMorador(@RequestBody String nome) throws Exception{
		return moradorService.pesquisarMorador(nome);
	}

}
