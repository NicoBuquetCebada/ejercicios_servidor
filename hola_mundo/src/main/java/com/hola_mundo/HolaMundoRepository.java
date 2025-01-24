package com.hola_mundo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola-mundo")
public class HolaMundoRepository {

	@GetMapping
	public String holaMundo() {
		return "Hola mundo!";
	}
}
