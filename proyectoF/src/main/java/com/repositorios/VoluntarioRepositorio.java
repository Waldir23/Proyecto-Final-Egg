package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entidades.Voluntario;


@Repository("VoluntarioRepositorio")
public interface VoluntarioRepositorio extends JpaRepository<Voluntario, String>{
	
}
