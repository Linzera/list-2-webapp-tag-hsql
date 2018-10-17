package br.ucsal.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ucsal.jdbc.dao.ContatoDao;
import br.ucsal.jdbc.modelo.Contato;

@WebServlet("/teste")
public class TestaConexaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContatoDao dao;
		try {
			dao = new ContatoDao();
			for (Contato c : dao.getLista()) {
				response.getWriter().append(c.getNome());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
