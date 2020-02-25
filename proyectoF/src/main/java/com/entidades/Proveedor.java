package com.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.Mapping;

@Entity
public class Proveedor {
	
	@Id
	@GeneratedValue(generator= "uuid")
	@GenericGenerator(name = "uuid", strategy="uuid2")
	private String id;
	private String email;
	private String clave;
	private double puntuacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date baja;
	
//	ver como persistir una lista adentro de una entidad
//	@OneToMany(cascade= CascadeType.ALL, mappedBy= "uuid2")
//	@OneToMany(targetEntity=Double.class)
//	private List<Double> listaPuntos;
	
	@OneToOne
	private Ubicacion ubicacion;
	
	//ver si crear una entidad Favorito (tabla intermedia) para simplificar 
	//la relacion @ManyToMany con Cliente
	
//	public Proveedor(String email, String clave, Date alta, Date baja, int puntuacion, Mensaje mensajes,
//			Donacion donaciones) {
//		super();
//		this.email = email;
//		this.clave = clave;
//		this.alta = alta;
//		this.baja = baja;
//		this.puntuacion = puntuacion;
//		this.mensajes = mensajes;
//		this.donaciones = donaciones;
//	}
	
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
	public double getPuntuacion() {
		return puntuacion;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
//	metodo para calcular la puntuacion (pero primero hay que persistir la lista)
//	public void setPuntos(double puntos) {
//		//
//		listaPuntos.add(puntos);
//		double aux =0;
//		for (Double d : listaPuntos) {
//			aux+=d;
//		}
//		puntuacion=new BigDecimal(aux/listaPuntos.size()).setScale(1, RoundingMode.HALF_UP).doubleValue();
//	}
	
	
}
