package com.ciceroinfo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			return DriverManager.getConnection(
					"jdbc:mysql://localhost/cicerodb", "root", "registro");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
