package com.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositorios.MensajeRepositorio;

@Service
public class MensajeServicio {

	@Autowired
	private MensajeRepositorio r;
	
}
