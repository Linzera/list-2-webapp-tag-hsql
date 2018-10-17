package br.ucsal.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import br.ucsal.jdbc.ConnectionFactory;

public class TestaConexao {

	private static boolean isRunning = true;
	private static Scanner sc;
	private static Connection connection;

	public static void main(String[] args) {

		start();

	}

	public static void start() {

		sc = new Scanner(System.in);

		while (isRunning) {

			System.out.println("Deseja testar o dao? ( S / N )");
			String res = sc.nextLine();

			if (res.equalsIgnoreCase("s")) {
				try {
					//abrirConexao();
					TestaDAO.testBeans();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (res.equals("exit")) {
				System.out.println("Shutting Down");
				isRunning = false;
			}

		}

	}

	@SuppressWarnings("unused")
	private static void abrirConexao() throws SQLException, ClassNotFoundException {

		connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao aberta!");
		connection.close();
	}

	@SuppressWarnings("unused")
	private static void insertStatementTest() throws SQLException {

		String sql = "INSERT INTO CONTATOS(NOME,EMAIL,ENDERECO,DATANASCIMENTO) VALUES "
				+ " ('Joao Duke', 'jduke@ucsal.br', 'Rua da Carvalho', '1996-01-23')";
		Statement statement = connection.createStatement();
		statement.execute(sql);
		statement.close();

	}

	@SuppressWarnings("unused")
	private static void preparedStatementTest() throws SQLException {
		String sql = "INSERT INTO CONTATOS(NOME,EMAIL,ENDERECO,DATANASCIMENTO) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "Joao Duke");
		preparedStatement.setString(2, "jduke@ucsal.br");
		preparedStatement.setString(3, "Rua da Carvalho");
		preparedStatement.setString(4, "1996-01-23");
		preparedStatement.execute();
		preparedStatement.close();
	}

}
