package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.servicios.ClienteServicio;
import com.servicios.ProveedorServicio;

@Configuration@EnableWebSecurity@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ClienteServicio cS;
	
	@Autowired
	private ProveedorServicio pS;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(cS).passwordEncoder(new BCryptPasswordEncoder())
		.and().userDetailsService(pS).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin().and().authorizeRequests()
			.antMatchers("/proveedor/**").hasRole("PROVEEDOR_REGISTRADO")
			.antMatchers("/cliente/**").hasRole("CLIENTE_REGISTRADO")
			.antMatchers("/**").permitAll()
		.and().formLogin()
			.loginPage("/login")//Agregar el nombre de la pagina de login
				.usernameParameter("user") // name del input de usuario en el login
				.passwordParameter("pass") // name del input de clave en el login
				.defaultSuccessUrl("/inicio")// primera pagina que te redirecciona despues de que te logueas
				.failureUrl("/error") // pagina que te redirecciona cuando falla el login  default is /login?error
				.loginProcessingUrl("/logincheck") // pagina que te redirecciona cuando esta procesando el login  default is /login
		.and().logout()
			.invalidateHttpSession(false)
			.logoutUrl("/logout") // pagina de logout
			.logoutSuccessUrl("/index") //pagina que te redirecciona cuando cerras sesion
			.permitAll().and().csrf().disable();
	}
}
