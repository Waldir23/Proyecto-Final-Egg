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
	@GenericGenerator(name="uuid", strategy="donacion")
	private String id;
	
	@ManyToOne
	private Evento eventos;
	//cuando este hecho el form de las donaciones le agregamos mas atributos
}
