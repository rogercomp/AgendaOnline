package agenda.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.modelo.Contato;
import agenda.modelo.ContatoDAO;

@WebServlet("/novo")
public class NovoContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        ContatoDAO dao = new ContatoDAO("jdbc:mysql://localhost:3306/contatos?useTimezone=true&serverTimezone=UTC", "root", "root");
		String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
	    Contato novo = new Contato(nome, telefone);
	    dao.inserir(novo);	
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html"); 
        dispatcher.forward(request, response);
	}
}
