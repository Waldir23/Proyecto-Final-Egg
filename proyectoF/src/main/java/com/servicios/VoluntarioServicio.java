package com.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositorios.VoluntarioRepositorio;

@Service
public class VoluntarioServicio {

	@Autowired
	private VoluntarioRepositorio r;
}
