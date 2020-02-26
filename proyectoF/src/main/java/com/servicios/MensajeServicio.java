package com.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entidades.Evento;
import com.entidades.Mensaje;
import com.entidades.Proveedor;
import com.repositorios.EventoRepositorio;
import com.repositorios.MensajeRepositorio;
import com.repositorios.ProveedorRepositorio;

@Service
public class MensajeServicio {

	@Autowired
	private MensajeRepositorio mR;
	
	@Autowired
	private ProveedorRepositorio pR;

	@Autowired
	private EventoRepositorio eR;
	
	@Transactional
	public void modificacion(String idMensaje, String contenido) {
		Optional<Mensaje> resp= mR.findById(idMensaje);
		if(resp.isPresent()) {
			Mensaje mensaje=resp.get();
			mensaje.setContenido(contenido);
			mR.save(mensaje);
		}
	}

	@Transactional
	public void guardar(String idForanea,String contenido, Class entidadDonada) {
		Optional resp=null;
		if (entidadDonada.equals(Proveedor.class)) {
			resp=pR.findById(idForanea);
		} else {
			if (entidadDonada.equals(Evento.class)) {
				resp=eR.findById(idForanea);
			}
		}
		if (resp.isPresent()) {
			Mensaje mensaje=new Mensaje();
			mensaje.setContenido(contenido);
			if(resp.getClass().equals(Proveedor.class)) {
				mensaje.setProveedores((Proveedor)resp.get());
			}			
			if(resp.getClass().equals(Evento.class)) {
				mensaje.setEventos((Evento)resp.get());
			}
			mR.save(mensaje);
		} else {
//			Falta hacer ErrorServicio
		}
	}
	
}
