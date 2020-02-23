package com.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositorios.EventoRepositorio;

@Service
public class EventoServicio {

	@Autowired
	private EventoRepositorio r;
	
}
