package agenda.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.modelo.ContatoDAO;


@WebServlet("/excluir")
public class ExcluirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        ContatoDAO dao = new ContatoDAO("jdbc:mysql://localhost:3306/contatos?useTimezone=true&serverTimezone=UTC", "root", "root");
        dao.excluir(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html"); 
        dispatcher.forward(request, response);
	}

	
}
