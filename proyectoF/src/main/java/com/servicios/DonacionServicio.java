package com.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entidades.Donacion;
import com.entidades.Evento;
import com.entidades.Proveedor;
import com.repositorios.DonacionRepositorio;
import com.repositorios.EventoRepositorio;
import com.repositorios.ProveedorRepositorio;

@Service
public class DonacionServicio {

	@Autowired
	private DonacionRepositorio dR;
	
	@Autowired
	private ProveedorRepositorio pR;

	@Autowired
	private EventoRepositorio eR;
	
	@Transactional
	public void guardar(String idForanea, Class entidadDonada) {
		Optional resp=null;
		if (entidadDonada.equals(Proveedor.class)) {
			resp=pR.findById(idForanea);
		} else {
			if (entidadDonada.equals(Evento.class)) {
				resp=eR.findById(idForanea);
			}
		}
		if (resp.isPresent()) {
			Donacion donacion=new Donacion();
//			Si se agregan otros atributos a Donacion, hay que agregar
//			los setters que hagan falta
			if(resp.getClass().equals(Proveedor.class)) {
				donacion.setProveedores((Proveedor)resp.get());
			}			
			if(resp.getClass().equals(Evento.class)) {
				donacion.setEventos((Evento)resp.get());
			}
			dR.save(donacion);
		} else {
//			Falta hacer ErrorServicio
		}
	}
	
}
