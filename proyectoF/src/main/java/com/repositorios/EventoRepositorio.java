package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entidades.Evento;


@Repository("EventoRepositorio")
public interface EventoRepositorio extends JpaRepository<Evento, String>{
	
}
