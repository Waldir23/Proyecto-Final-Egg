package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entidades.Ubicacion;


@Repository("UbicacionRepositorio")
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, String>{
	
}
