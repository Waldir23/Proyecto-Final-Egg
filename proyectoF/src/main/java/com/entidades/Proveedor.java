package com.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proveedor {
	
	@Id
	@GeneratedValue(generator= "uuid")
	@GenericGenerator(name = "uuid", strategy="uuid2")
	private String id;
	private String email;
	private String clave;
	private Date alta;
	private Date baja;
	private int puntuacion;
	
	public Proveedor(String email, String clave, Date alta, Date baja, int puntuacion, Mensaje mensajes,
			Donacion donaciones) {
		super();
		this.email = email;
		this.clave = clave;
		this.alta = alta;
		this.baja = baja;
		this.puntuacion = puntuacion;
		this.mensajes = mensajes;
		this.donaciones = donaciones;
	}
	@ManyToOne
	private Mensaje mensajes;

	@ManyToOne
	private Donacion donaciones;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public Date getBaja() {
		return baja;
	}
	public void setBaja(Date baja) {
		this.baja = baja;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Mensaje getMensajes() {
		return mensajes;
	}
	public void setMensajes(Mensaje mensajes) {
		this.mensajes = mensajes;
	}
	
}
