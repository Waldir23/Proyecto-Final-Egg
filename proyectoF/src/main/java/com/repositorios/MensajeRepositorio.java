package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entidades.Mensaje;


@Repository("MensajeRepositorio")
public interface MensajeRepositorio extends JpaRepository<Mensaje, String>{
	
}
