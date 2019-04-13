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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atualizar")
public class AtualizarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//String nome = request.getParameter("nome");
       // String telefone = request.getParameter("telefone");   
        
        ContatoDAO dao = new ContatoDAO("jdbc:mysql://localhost:3306/contatos?useTimezone=true&serverTimezone=UTC", "root", "root");
        Contato alterado = dao.buscaPorId(id);
              		
		request.setAttribute("contato", alterado);
		
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("alterado.jsp"); 
        dispatcher.forward(request, response);
	}

}
