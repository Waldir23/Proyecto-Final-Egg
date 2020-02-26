package com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mensaje {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	private String contenido;
	
	@ManyToOne
	private Evento eventos;
	
	@ManyToOne
	private Proveedor proveedores;
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
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
