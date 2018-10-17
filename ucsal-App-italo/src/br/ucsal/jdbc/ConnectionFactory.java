package br.ucsal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		String url = "jdbc:hsqldb:hsql://localhost/agenda";
		String user = "sa";
		String password = "";

		return DriverManager.getConnection(url, user, password);

	}

}
