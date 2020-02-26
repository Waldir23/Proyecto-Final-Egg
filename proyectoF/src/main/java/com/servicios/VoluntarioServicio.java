package com.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entidades.Donacion;
import com.entidades.Evento;
import com.entidades.Proveedor;
import com.entidades.Voluntario;
import com.repositorios.EventoRepositorio;
import com.repositorios.ProveedorRepositorio;
import com.repositorios.VoluntarioRepositorio;

@Service
public class VoluntarioServicio {

	@Autowired
	private VoluntarioRepositorio vR;
	

	@Autowired
	private ProveedorRepositorio pR;

	@Autowired
	private EventoRepositorio eR;
	
	@Transactional
	public void guardar(String idForanea,String nombre,String apellido, String email, int celular, Class entidadDonada) {
		Optional resp=null;
		if (entidadDonada.equals(Proveedor.class)) {
			resp=pR.findById(idForanea);
		} else {
			if (entidadDonada.equals(Evento.class)) {
				resp=eR.findById(idForanea);
			}
		}
		
		if (resp.isPresent()) {
			Voluntario voluntario=new Voluntario();
			voluntario.setApellido(apellido);
			voluntario.setCelular(celular);
			voluntario.setEmail(email);
			voluntario.setNombre(nombre);
//			voluntario.setDiasDisponibles(diasDisponibles);
			if(resp.getClass().equals(Proveedor.class)) {
				voluntario.setProveedores((Proveedor)resp.get());
			}			
			if(resp.getClass().equals(Evento.class)) {
				voluntario.setEventos((Evento)resp.get());
			}
			vR.save(voluntario);
		} else {
//			Falta hacer ErrorServicio
		}
	}
}
