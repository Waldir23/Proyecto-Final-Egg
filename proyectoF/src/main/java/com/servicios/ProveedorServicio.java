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

import com.entidades.Donacion;
import com.entidades.Evento;
import com.entidades.Mensaje;
import com.entidades.Proveedor;
import com.entidades.Ubicacion;
import com.repositorios.ProveedorRepositorio;

@Service
public class ProveedorServicio implements UserDetailsService{
	
	@Autowired
	private ProveedorRepositorio pR;
	
	@Autowired
	private DonacionServicio dS;
	
	@Autowired
	private MensajeServicio mS;
	
	@Autowired
	private EventoServicio eS;
	
	@Autowired
	private UbicacionServicio uS;
	
	@Transactional
	public void alta(String email, String clave, Ubicacion domicilio) {
		validar();
		Proveedor proveedor=new Proveedor();
		proveedor.setAlta(new Date());
		proveedor.setEmail(email);
		proveedor.setClave(new BCryptPasswordEncoder().encode(clave));
		Ubicacion ubicacion= uS.guardar(domicilio);
		proveedor.setUbicacion(ubicacion);
		pR.save(proveedor);
	}

	@Transactional
	public void deshabilitar(String idProveedor) {
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			Proveedor proveedor=resp.get();
			proveedor.setBaja(new Date());
			pR.save(proveedor);
		}
	}
	
	@Transactional
	public void habilitar(String idProveedor) {
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			Proveedor proveedor=resp.get();
			proveedor.setBaja(null);
			pR.save(proveedor);
		}
	}

	@Transactional
	public void eliminar(String idProveedor) {
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			pR.delete(resp.get());
		}
	}

	@Transactional
	public void modificar(String idProveedor,String email, String clave, Ubicacion domicilio) {
		validar();
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			Proveedor proveedor=resp.get();
			proveedor.setEmail(email);
			proveedor.setClave(new BCryptPasswordEncoder().encode(clave));
			Ubicacion ubicacion= uS.guardar(domicilio);
			proveedor.setUbicacion(ubicacion);
			pR.save(proveedor);
		}
	}

	@Transactional
	public void agregarPuntos(String idProveedor,double puntos) {
//		Optional<Proveedor> resp= pR.findById(idProveedor);
//		if(resp.isPresent()) {
//			Proveedor proveedor=resp.get();
////			proveedor.setPuntos(puntos);
//			pR.save(proveedor);
//		}
	}
	
	@Transactional
	public void agregarDonacion(String idProveedor) {
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			Proveedor proveedor=resp.get();
			dS.guardar(proveedor.getId(), proveedor.getClass());
		}
	}
	
	@Transactional
	public void agregarMensaje(String idProveedor,String contenido) {
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			Proveedor proveedor=resp.get();
			mS.guardar(proveedor.getId(),contenido, proveedor.getClass());
		}
	}
	
	@Transactional
	public void agregarEvento(String idProveedor) {
		Optional<Proveedor> resp= pR.findById(idProveedor);
		if(resp.isPresent()) {
			Proveedor proveedor=resp.get();
//			eS.guardar(proveedor.getId(), proveedor.getClass());
		}
	}
	
	private void validar() {
		//no se si las validaciones se van a hacer en el back
		//o en el front con Javascript
	}

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Proveedor proveedor=pR.buscarPorEmail(mail);
		if (proveedor !=null) {
			List<GrantedAuthority> permisos= new ArrayList<GrantedAuthority>();
			permisos.add(new SimpleGrantedAuthority("ROLE_PROVEEDOR_REGISTRADO"));
			HttpSession sesion= ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(true);
			sesion.setAttribute("proveedorSesion", proveedor);
			return  new User(proveedor.getEmail(),proveedor.getClave(), permisos);
		} else {
			return null;
		}
	}
	
}
