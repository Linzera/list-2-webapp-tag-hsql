package br.ucsal.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.ucsal.jdbc.ConnectionFactory;
import br.ucsal.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() throws SQLException, ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Contato contato) throws SQLException {

		String sql = "delete from contatos where id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, contato.getId());
		stmt.execute();
		stmt.close();

	}

	public void altera(Contato contato) throws SQLException {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
		stmt.setLong(5, contato.getId());
		stmt.execute();
		stmt.close();

	}

	public List<Contato> getLista() throws SQLException {

		List<Contato> contatos = new ArrayList<Contato>();

		String sql = "select * from contatos";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
			contatos.add(contato);
		}
		rs.close();
		stmt.close();
		return contatos;

	}

}
