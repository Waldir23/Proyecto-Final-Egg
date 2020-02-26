package com.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Voluntario {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String id;
	private String nombre;
	private String apellido;
	private String email;
	private int celular;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date diasDisponibles;
	
	@ManyToOne
	private Evento eventos;
	
	@ManyToOne
	private Proveedor proveedores;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public Date getDiasDisponibles() {
		return diasDisponibles;
	}
	public void setDiasDisponibles(Date diasDisponibles) {
		this.diasDisponibles = diasDisponibles;
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
