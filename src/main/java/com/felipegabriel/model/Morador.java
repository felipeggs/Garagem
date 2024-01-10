package com.felipegabriel.model;

public class Morador extends BaseEntity {
	private String bloco;
	private String cpf;
	private String numero;
	private String nome;
	private String numGaragem;
	
	public Morador() {
		
	}
	
	public Morador(String bloco, String cpf, String numero, String nome, String numGaragem) {
		this.bloco = bloco;
		this.cpf = cpf;
		this.numero = numero;
		this.nome = nome;
		this.numGaragem = numGaragem;
		
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumGaragem() {
		return numGaragem;
	}

	public void setNumGaragem(String numGaragem) {
		this.numGaragem = numGaragem;
	}
	
	@Override
	public String toString() {
		return "Morador: \nBloco: " + bloco + "\nCPF: " + cpf + "\nNumero: " + numero + "\nNome: " + nome + "\nNumGaragem: " + numGaragem;
	}
	
	

}
