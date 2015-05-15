package com.ciceroinfo.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciceroinfo.mvc.logica.Logica;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String l = "com.ciceroinfo.mvc.logica." + request.getParameter("logica");
		
		try {
			
			@SuppressWarnings("unchecked")
			Class<Logica> clazz = (Class<Logica>) Class.forName(l);
			
			Logica logica = clazz.newInstance();
			
			logica.executa(request, response);
			
		} catch (Exception e) {
			throw new ServletException("Erro na logica de negocio", e);
		}
	}
}
