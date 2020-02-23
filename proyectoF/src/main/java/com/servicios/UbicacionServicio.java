package com.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entidades.Ubicacion;
import com.repositorios.UbicacionRepositorio;

@Service
public class UbicacionServicio {

	@Autowired
	private UbicacionRepositorio r;

	public Ubicacion guardar(Ubicacion domicilio) {
		return null;
	}
}
