package com.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entidades.Proveedor;
import com.entidades.Ubicacion;
import com.repositorios.ProveedorRepositorio;
import com.servicios.ProveedorServicio;

@Controller @RequestMapping("/")
public class PruebaControllerConJSON {
	
	@Autowired
	ProveedorServicio pS;
	
	@Autowired
	ProveedorRepositorio pR;
	
	@GetMapping
	public String index() {
		return "index.html";
	}
	
	@GetMapping(path="/jsonGimnasios", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proveedor>> prueba() {
		Ubicacion domicilio=new Ubicacion();
		domicilio.setLatitud(12.34567890);
		domicilio.setLongitud(12.34567890);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		pS.alta("test", "12345", domicilio);
		List<Proveedor> list=pR.findAll();
		return new ResponseEntity<List<Proveedor>> (list,HttpStatus.OK);
	}
}
