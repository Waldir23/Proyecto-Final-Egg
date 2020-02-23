package com.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.entidades.Cliente;
import com.entidades.Ubicacion;
import com.repositorios.ClienteRepositorio;
import com.repositorios.ProveedorRepositorio;
import com.repositorios.UbicacionRepositorio;

@Service
public class ClienteServicio implements UserDetailsService{
	
	@Autowired
	private ClienteRepositorio cR;
	
	@Autowired
	private ProveedorRepositorio pR;
	
	@Autowired
	private ProveedorServicio pS;
	
	@Autowired
	private UbicacionRepositorio uR;
	
	@Autowired
	private UbicacionServicio uS;
	
	@Transactional
	public void alta(String email, String clave, Ubicacion domicilio) {
		validar();
		Cliente cliente=new Cliente();
		cliente.setAlta(new Date());
		cliente.setEmail(email);
		cliente.setClave(new BCryptPasswordEncoder().encode(clave));
		Ubicacion ubicacion= uS.guardar(domicilio);
		cliente.setUbicacion(ubicacion);
		cR.save(cliente);
	}

	@Transactional
	public void deshabilitar(String idCliente) {
		Optional<Cliente> resp= cR.findById(idCliente);
		if(resp.isPresent()) {
			Cliente cliente=resp.get();
			cliente.setBaja(new Date());
			cR.save(cliente);
		}
	}
	

	@Transactional
	public void habilitar(String idCliente) {
		Optional<Cliente> resp= cR.findById(idCliente);
		if(resp.isPresent()) {
			Cliente cliente=resp.get();
			cliente.setBaja(null);
			cR.save(cliente);
		}
	}

	@Transactional
	public void eliminar(String idCliente){
		Optional<Cliente> resp= cR.findById(idCliente);
		if(resp.isPresent()) {
			Cliente cliente=resp.get();
			cR.delete(cliente);
		}
	}

	@Transactional
	public void modificacion(String idCliente, String email, String clave, Ubicacion domicilio) {
		Optional<Cliente> resp= cR.findById(idCliente);
		if(resp.isPresent()) {
			Cliente cliente=resp.get();
			cliente.setEmail(email);
			Ubicacion ubicacion= uS.guardar(domicilio);
			cliente.setUbicacion(ubicacion);
			cR.save(cliente);
		}
	}

	private void validar() {
		
	}

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Cliente cliente=cR.buscarPorMail(mail);
		if (cliente !=null) {
			List<GrantedAuthority> permisos= new ArrayList<GrantedAuthority>();
			permisos.add(new SimpleGrantedAuthority("ROL_CLIENTE_REGISTRADO"));
			HttpSession sesion= ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(true);
			sesion.setAttribute("usuarioSesion", cliente);
			return  new User(cliente.getEmail(),cliente.getClave(), permisos);
		} else {
			return null;
		}
	}
	
}
