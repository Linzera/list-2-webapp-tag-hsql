package br.ucsal.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.jdbc.dao.ContatoDao;

@WebServlet("/")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ContatoDao dao = new ContatoDao();
			request.setAttribute("lista", dao.getLista());
			RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
