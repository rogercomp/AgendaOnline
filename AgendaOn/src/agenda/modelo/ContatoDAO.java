package agenda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agenda.util.CriaBancoDeDados;

public class ContatoDAO {
	private String url, usuario, senha;

    public ContatoDAO(String url, String usuario, String senha) {
            super();
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
            this.url = url;
            this.usuario = usuario;
            this.senha = senha;
    }

    public void excluir(int id) {
            String sql = "delete from contato where id=" + id;
            Connection con;
            Statement stmt;
            try {
                    con = DriverManager.getConnection(url, usuario, senha);
                    stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
    }

    public void inserir(Contato c) {
            String sql_novoContato = "insert into contato(nome,telefone) values('" + c.getNome() + "','" + c.getTelefone() + "');";
            Connection con;
            Statement stmt;
            try {
                    con = DriverManager.getConnection(url, usuario, senha);
                    stmt = con.createStatement();
                    stmt.executeUpdate(sql_novoContato);
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
    }

    public List<Contato> buscaTodos() {
            String sql_novoContato = "select * from contato;";
            Connection con;
            Statement stmt;
            ResultSet resultados;
            String nome, telefone;
            int id;
            List<Contato> lista = new ArrayList<Contato>();
            try {
                    con = DriverManager.getConnection(url, usuario, senha);
                    stmt = con.createStatement();
                    resultados = stmt.executeQuery(sql_novoContato);
                    while (resultados.next()) {
                    	    id = resultados.getInt("id");
                            nome = resultados.getString("nome");
                            telefone = resultados.getString("telefone");
                            lista.add(new Contato(nome, telefone, id));
                    }
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
            return lista;
    }

    public Contato buscaPorId(int id) {
            String sql = "select * from contato where id=" + id + ";";
            Connection con;
            Statement stmt;
            ResultSet resultados;
            String nome = null, telefone = null;            
            try {
                    con = DriverManager.getConnection(url, usuario, senha);
                    stmt = con.createStatement();
                    resultados = stmt.executeQuery(sql);
                    if (resultados.next()) {                    	    
                            nome = resultados.getString("nome");
                            telefone = resultados.getString("telefone");
                    }
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
            return new Contato(nome, telefone, id);
    }

    public void atualizar(Contato novo) {
            String sql_alteraContato = "update contato set nome='" + novo.getNome() + "' where id='" + novo.getId() + "';";
            Connection con;
            Statement stmt;
            try {
                    con = DriverManager.getConnection(url, usuario, senha);
                    stmt = con.createStatement();
                    stmt.executeUpdate(sql_alteraContato);
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }

    }
}
