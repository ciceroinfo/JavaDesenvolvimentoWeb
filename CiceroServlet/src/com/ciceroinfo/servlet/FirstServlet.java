package com.ciceroinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciceroinfo.bo.Contato;
import com.ciceroinfo.dao.ContatoDAO;
import com.ciceroinfo.dao.DAO;

public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		try {
			Connection connection = (Connection) request
					.getAttribute("connection");

			DAO<Contato> dao = new ContatoDAO(connection);
			
			dao.add(new Contato());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();

		out.println("<html><body><h1>Test Servlet</h1></body></html>");
	}

}
