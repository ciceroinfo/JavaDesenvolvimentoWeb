package com.ciceroinfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ciceroinfo.bo.Contato;

public class ContatoDAO implements DAO<Contato> {

	private Connection conn = null;

	public ContatoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean add(Contato contato) throws SQLException {

		String sql = "insert into cicerodb.contato (nome, email, endereco, data_nascimento) values (?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		
		if (contato.getDataNascimento() != null) {
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		} else {
			stmt.setDate(4, null);
		}
		

		return stmt.execute();
	}

	@Override
	public boolean remove(Contato contato) throws SQLException {
		
		String sql = "delete from cicerodb.contato where id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setLong(1, contato.getId());
		
		return stmt.execute();
	}

	@Override
	public boolean edit(Contato contato) throws SQLException {

		String sql = "update cicerodb.contato set nome=?, email=?, endereco=?, data_nascimento=?) where id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getId());

		return stmt.execute();
	}

	@Override
	public List<Contato> getList() {

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			String sql = "select * from cicerodb.contato";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));

				contato.setDataNascimento(data);

				contatos.add(contato);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return contatos;
	}

	@Override
	public Contato getById(long id) throws SQLException {
		
		String sql = "select * from cicerodb.contato where id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {

			Contato contato = new Contato();

			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));

			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_nascimento"));

			contato.setDataNascimento(data);

			return contato;

		}

		
		return null;
	}

}
