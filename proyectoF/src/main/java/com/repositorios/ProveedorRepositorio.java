package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entidades.Proveedor;

@Repository("ProveedorRepositorio")
public interface ProveedorRepositorio extends JpaRepository<Proveedor, String>{
	
	@Query("SELECT p FROM Proveedor p WHERE p.email =:email")
	Proveedor buscarPorEmail(@Param("email") String email);
	
}
