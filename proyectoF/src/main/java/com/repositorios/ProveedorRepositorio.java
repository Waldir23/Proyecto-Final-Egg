package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entidades.Proveedor;

@Repository("ProveedorRepositorio")
public interface ProveedorRepositorio extends JpaRepository<Proveedor, String>{
	
}
