package com.casa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Puerta {
	private String color;
	private String estilo;
	private Pomo pomo;

	 @Autowired
	public Puerta(Pomo pomo) {
		this.color = "rojo";
		this.estilo = "barroco";
		this.pomo = pomo;
	}

	public Puerta(String color, String estilo, Pomo pomo) {
		this.color = color;
		this.estilo = estilo;
		this.pomo = pomo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public Pomo getPomo() {
		return pomo;
	}

	public void setPomo(Pomo pomo) {
		this.pomo = pomo;
	}
}
