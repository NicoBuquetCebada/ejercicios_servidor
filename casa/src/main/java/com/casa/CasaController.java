package com.casa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casa")
public class CasaController {
	@Autowired
	private Casa casa;

	@GetMapping
	public ResponseEntity<Casa> getCasa() {
		return ResponseEntity.ok(casa);
	}

}
