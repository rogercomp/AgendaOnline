package agenda.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.modelo.Contato;
import agenda.modelo.ContatoDAO;


@WebServlet("/listar")
public class ControleListaTodosContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ContatoDAO dao = new ContatoDAO("jdbc:mysql://localhost:3306/contatos?useTimezone=true&serverTimezone=UTC", "root", "root");
        List<Contato> lista = dao.buscaTodos();
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todos.jsp");
        dispatcher.forward(request, response);
	}	
	

}
