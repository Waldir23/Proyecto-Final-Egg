package com.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {

	@GetMapping("/")
	public String Index() {
		return "index.html";
	}
	
	@GetMapping("/registro")
	public String Registro() {
		return "registro.html";
	}
	
	@GetMapping("/login")
	public String Logi() {
		return "registro.html";
	}
	
	@GetMapping("/donaciones")
	public String Donaciones() {
		return "donaciones.html";
	}
	
	@GetMapping("/voluntarios")
	public String Voluntarios() {
		return "voluntarios.html";
	}
	
	@GetMapping("/eventos")
	public String Eventos() {
		return "eventos.html";
	}
}
