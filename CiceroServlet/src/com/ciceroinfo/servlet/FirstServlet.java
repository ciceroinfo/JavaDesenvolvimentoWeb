package com.ciceroinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciceroinfo.bo.Contato;
import com.ciceroinfo.dao.ContatoDAO;

public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		try {
			new ContatoDAO().add(new Contato());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>Test Servlet</h1></body></html>");
	}

}
