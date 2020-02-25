package com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Donacion {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	@ManyToOne
	private Evento eventos;

	@ManyToOne
	private Proveedor proveedores;
	//cuando este hecho el form de las donaciones agregamos los atributos que hagan falta

	public Evento getEventos() {
		return eventos;
	}

	public void setEventos(Evento eventos) {
		this.eventos = eventos;
	}

	public Proveedor getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor proveedores) {
		this.proveedores = proveedores;
	}
	
	
}
