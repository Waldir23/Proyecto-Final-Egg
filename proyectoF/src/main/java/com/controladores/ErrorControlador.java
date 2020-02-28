package com.controladores;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorControlador implements ErrorController{
	
	@RequestMapping(value="error",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView PaginaError(HttpServletRequest request) {
		ModelAndView paginaError= new ModelAndView("error");
		String mensaje="";
		switch (errorCodigo(request)) {
		case 400:
			mensaje="Escribir mensaje para el 400";//recursos
			break;
		case 401:
			mensaje="Escribir mensaje para el 401";//permisos
			break;
		case 403:
			mensaje="Escribir mensaje para el 403";//autorizaciones
			break;
		case 500:
			mensaje="Escribir mensaje para el 500";//error del lado del servidor
			break;
		}
		paginaError.addObject("codigo",errorCodigo(request));
		paginaError.addObject("mensaje",mensaje);
		return paginaError;
	}
	
	private int errorCodigo(HttpServletRequest request) {
		Map mapa= request.getParameterMap();
		for (Object key : mapa.keySet()) {
			for (String valor: (String[])mapa.get(key)) {
				System.out.println(key.toString()+": "+valor);
			}
		}
		Enumeration<String> atributos = request.getAttributeNames();
		while(atributos.hasMoreElements()) {
			String key = atributos.nextElement();
			System.out.println(key+": "+request.getAttribute(key));
		}
		return (Integer) request.getAttribute("javax.servlet.error.status_code");
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
