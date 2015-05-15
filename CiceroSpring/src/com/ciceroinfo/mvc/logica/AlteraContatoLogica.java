package com.ciceroinfo.mvc.logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciceroinfo.bo.Contato;
import com.ciceroinfo.dao.ContatoDAO;
import com.ciceroinfo.dao.DAO;

public class AlteraContatoLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {

			Connection connection = (Connection) request
					.getAttribute("connection");

			DAO<Contato> dao = new ContatoDAO(connection);

			Contato contato = new Contato();

			contato.setId(Long.parseLong(request.getParameter("nome")));
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setEndereco(request.getParameter("endereco"));

			Calendar dataNascimento = null;

			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request
					.getParameter("dataNascimento"));

			dataNascimento = Calendar.getInstance();

			dataNascimento.setTime(date);

			contato.setDataNascimento(dataNascimento);

			dao.edit(contato);

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("lista-contato.html");

		rd.forward(request, response);

	}
}
