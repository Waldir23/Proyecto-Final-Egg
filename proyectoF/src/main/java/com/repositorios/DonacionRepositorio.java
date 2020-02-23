package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entidades.Donacion;


@Repository("DonacionRepositorio")
public interface DonacionRepositorio extends JpaRepository<Donacion, String>{
	
}
