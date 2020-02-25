package com.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entidades.Cliente;
import com.entidades.Mensaje;
import com.entidades.Ubicacion;
import com.repositorios.MensajeRepositorio;

@Service
public class MensajeServicio {

	@Autowired
	private MensajeRepositorio mR;
	
	@Transactional
	public void modificacion(String idMensaje, String contenido) {
		Optional<Mensaje> resp= mR.findById(idMensaje);
		if(resp.isPresent()) {
			Mensaje mensaje=resp.get();
			mensaje.setContenido(contenido);
			mR.save(mensaje);
		}
	}

	public Mensaje guardar(Mensaje mensaje, String idProveedor) {
		return null;
	}
	
}
