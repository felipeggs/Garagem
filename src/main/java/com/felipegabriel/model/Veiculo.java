package com.felipegabriel.model;

public class Veiculo extends BaseEntity {
	private String cor;
	private String placa;
	private String marca;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Veiculo [cor=" + cor + ", placa=" + placa + ", marca=" + marca + "]";
	}

	
}
