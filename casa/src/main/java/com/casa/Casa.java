package com.casa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Casa {
	private Integer id;
	private Integer mc;
	private Puerta puerta;

	@Autowired
	public Casa(Puerta puerta) {
		this.id = 1;
		this.mc = 200;
		this.puerta = puerta;
	}

	public Casa(Integer id, Integer mc, Puerta puerta) {
		this.id = id;
		this.mc = mc;
		this.puerta = puerta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMc() {
		return mc;
	}

	public void setMc(Integer mc) {
		this.mc = mc;
	}

	public Puerta getPuerta() {
		return puerta;
	}

	public void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}
}
