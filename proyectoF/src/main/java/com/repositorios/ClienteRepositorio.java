
package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entidades.Cliente;


@Repository("clienteRepositorio")
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{
	
<<<<<<< HEAD
	@Query("SELECT c FROM Cliente c WHERE c.email = :email")
	public Cliente buscarPorEmail(@Param("email") String email);
=======
	@Query("SELECT c FROM Cliente c WHERE c.email = :mail")
	public Cliente buscarPorMail(@Param("mail") String mail);
>>>>>>> refs/remotes/origin/master
	
}
