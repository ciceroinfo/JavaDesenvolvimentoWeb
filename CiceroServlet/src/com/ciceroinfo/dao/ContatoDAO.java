package com.ciceroinfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import com.ciceroinfo.bo.Contato;
import com.ciceroinfo.db.ConnectionFactory;

public class ContatoDAO {

	public boolean add(Contato contato) throws SQLException {

		Connection conn = new ConnectionFactory().getConnection();

		String sql = "insert into cicerodb.contato (nome, email, endereco, data_nascimento) values (?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, "Cícero");
		stmt.setString(2, "cicero@cicero");
		stmt.setString(3, "endereço ciero");
		stmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));

		stmt.execute();

		return true;
	}

}
