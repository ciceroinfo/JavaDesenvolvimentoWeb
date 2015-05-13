package com.ciceroinfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ciceroinfo.bo.Contato;
import com.ciceroinfo.db.ConnectionFactory;

public class ContatoDAO implements DAO<Contato> {

	private Connection conn = null;

	public ContatoDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	@Override
	public boolean add(Contato contato) throws SQLException {

		String sql = "insert into cicerodb.contato (nome, email, endereco, data_nascimento) values (?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

		stmt.execute();

		return true;
	}

	@Override
	public boolean remove(Contato contato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(Contato contato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contato> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
