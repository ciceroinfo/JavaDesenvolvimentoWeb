package com.ciceroinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciceroinfo.bo.Contato;
import com.ciceroinfo.dao.ContatoDAO;
import com.ciceroinfo.dao.DAO;

public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		try {
			DAO<Contato> dao = new ContatoDAO();

			Contato contato = new Contato();

			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setEndereco(request.getParameter("endereco"));

			Calendar dataNascimento = null;

			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request
					.getParameter("dataNascimento"));

			dataNascimento = Calendar.getInstance();

			dataNascimento.setTime(date);

			contato.setDataNascimento(dataNascimento);

			dao.add(contato);

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();

		out.println("<html><body><h1>Test Servlet</h1></body></html>");
	}
}
