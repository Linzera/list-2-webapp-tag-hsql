package br.ucsal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.jdbc.dao.ContatoDao;
import br.ucsal.jdbc.modelo.Contato;

@WebServlet("/InserirServlet")
public class InserirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InserirServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Contato contato = new Contato();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimento = request.getParameter("dataNascimento");
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(LocalDate.parse(dataNascimento));

		ContatoDao contatoDao;

		try {
			contatoDao = new ContatoDao();
			contatoDao.adiciona(contato);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/ucsal-App-italo/listar");

	}

}
