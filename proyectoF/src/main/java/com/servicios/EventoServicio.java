package com.servicios;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entidades.Evento;
import com.entidades.Mensaje;
import com.entidades.Proveedor;
import com.repositorios.EventoRepositorio;
import com.repositorios.ProveedorRepositorio;

@Service
public class EventoServicio {

	@Autowired
	private EventoRepositorio eR;
	
	@Autowired
	private ProveedorRepositorio pR;
	
	@Autowired
	private UbicacionServicio uS;

	@Autowired
	private DonacionServicio dS;
	
	@Autowired
	private MensajeServicio mS;
	
	@Autowired
	private VoluntarioServicio vS;
	
	@Transactional
	public void guardar(String idProveedor,String descripcion, Date fechaHora) {
		Optional <Proveedor> resp=pR.findById(idProveedor);
		if (resp.isPresent()) {
			Evento evento=new Evento();
			evento.setDescripcion(descripcion);
			evento.setFechaHora(fechaHora);
			evento.setProveedores(resp.get());
			eR.save(evento);
		} else {
//			Falta hacer ErrorServicio
		}
	}
	
	@Transactional
	public void eliminar(String idProveedor,String idEvento) {
		Optional <Proveedor> resp=pR.findById(idProveedor);
		if (resp.isPresent()) {
			Optional <Evento> resp2=eR.findById(idEvento);
			if (resp2.isPresent()) {
				eR.delete(resp2.get());
			}else {
//				Falta ErrorServicio
			}
		} else {
//			Falta hacer ErrorServicio
		}
	}
	

	@Transactional
	public void agregarDonacion(String idEvento) {
		Optional<Evento> resp= eR.findById(idEvento);
		if(resp.isPresent()) {
			Evento evento=resp.get();
			dS.guardar(evento.getId(), evento.getClass());
		}
	}
	
	@Transactional
	public void agregarMensaje(String idEvento,String contenido) {
		Optional<Evento> resp= eR.findById(idEvento);
		if(resp.isPresent()) {
			Evento evento=resp.get();
			mS.guardar(evento.getId(),contenido, evento.getClass());
		}
	}
	
	@Transactional
	public void agregarVoluntario(String idEvento,String nombre, String apellido,String email,int celular,Date diasDisponibles) {
		Optional<Evento> resp= eR.findById(idEvento);
		if(resp.isPresent()) {
			Evento evento=resp.get();
			vS.guardar(evento.getId(),nombre,apellido,email,celular,diasDisponibles, evento.getClass());
		}
	}
}
