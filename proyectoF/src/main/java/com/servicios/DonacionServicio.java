package com.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositorios.DonacionRepositorio;

@Service
public class DonacionServicio {

	@Autowired
	private DonacionRepositorio r;
	
}
