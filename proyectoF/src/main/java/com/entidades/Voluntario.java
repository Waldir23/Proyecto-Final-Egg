package com.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Voluntario {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="voluntario")
	private String id;
	private String nombre;
	private String apellido;
	private String email;
	private int celular;
	private Date diasDisponibles;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
}
