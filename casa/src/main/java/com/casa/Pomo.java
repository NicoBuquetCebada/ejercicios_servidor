package com.casa;

import org.springframework.stereotype.Component;

@Component
public class Pomo {
	private String tipo;
	private Integer precio;

	public Pomo() {
		this.tipo = "feo";
		this.precio = 10;
	}

	public Pomo(String tipo, Integer precio) {
		this.tipo = tipo;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
