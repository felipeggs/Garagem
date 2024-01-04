package com.felipegabriel.model;

public class Morador extends BaseEntity {
	private String nome;
	private String numero;
	private String cpf;
	private String numGaragem;
	private String bloco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumGaragem() {
		return numGaragem;
	}

	public void setNumGaragem(String numGaragem) {
		this.numGaragem = numGaragem;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	@Override
	public String toString() {
		return "Morador [nome=" + nome + ", numero=" + numero + ", cpf=" + cpf + ", numGaragem=" + numGaragem
				+ ", bloco=" + bloco + "]";
	}

}
