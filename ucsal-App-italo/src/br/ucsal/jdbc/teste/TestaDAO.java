package br.ucsal.jdbc.teste;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.ucsal.jdbc.dao.ContatoDao;
import br.ucsal.jdbc.modelo.Contato;

public class TestaDAO {

	public static void testBeans() throws SQLException, ClassNotFoundException {
		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		contato.setNome("Joao Duke");
		contato.setEmail("jduke@ucsal.br");
		contato.setEndereco("Rua da Carvalho");
		contato.setDataNascimento(LocalDate.parse("1996-01-23"));
		System.out.println("Novo Contato: ");
		System.out.println("Id: " + contato.getId() + " Nome:" + contato.getNome());
		dao.adiciona(contato);
		List<Contato> contatos = dao.getLista();
		contato = contatos.get(0);
		System.out.println("Primeiro contato da lista: ");
		System.out.println("Id: " + contato.getId() + " Nome:" + contato.getNome());
		System.out.println("Altera Contato: ");
		contato.setNome("Joao Duke Alterado");
		System.out.println("Id: " + contato.getId() + " Nome:" + contato.getNome());
		dao.altera(contato);
		System.out.println("Lista Contatos: ");
		for (Contato c : dao.getLista()) {
			System.out.println("Id: " + c.getId() + " Nome:" + c.getNome());
		}
		System.out.println("Excluir Contato");
		System.out.println("Id: " + contato.getId() + " Nome:" + contato.getNome());
		//Comentado para visualizar lista, pode descomentar pra testar!
		//dao.remove(contato);
		System.out.println("Lista Contatos: ");
		for (Contato c : dao.getLista()) {
			System.out.println("Id: " + c.getId() + " Nome:" + c.getNome());
		}

	}

}
