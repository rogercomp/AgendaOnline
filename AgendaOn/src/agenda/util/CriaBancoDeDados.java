package agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import agenda.modelo.Contato;
import agenda.modelo.ContatoDAO;

public class CriaBancoDeDados {
	
	private static String sql_criaBanco = "create database contatos";
    private static String sql_criaTabela = "CREATE TABLE contato(nome varchar(50), telefone varchar(10),id int(11)) ENGINE=InnoDB DEFAULT CHARSET=utf8;" + "/ ALTER TABLE contato ADD PRIMARY KEY (id);"
                    + "/ ALTER TABLE contato MODIFY COLUMN id INT AUTO_INCREMENT;" + "/ COMMIT;";

    public static void criaBase(String url, String usuario, String senha) {
            Connection con;
            Statement stmt;
            try {
                    String urlSemNomeDaBase = url.replace("/contatos", "");
                    con = DriverManager.getConnection(urlSemNomeDaBase, usuario, senha);
                    stmt = con.createStatement();
                    stmt.execute(sql_criaBanco);
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
    }

    public static void criaTabela(String url, String usuario, String senha) {
            Connection con;
            Statement stmt;
            String comandos[] = sql_criaTabela.split("/");
            try {
                    con = DriverManager.getConnection(url, usuario, senha);
                    stmt = con.createStatement();
                    for (String sql : comandos) {
                            stmt.execute(sql);
                    }
                    stmt.close();
                    con.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
    }

    public static void main(String[] args) {
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
            CriaBancoDeDados.criaBase("jdbc:mysql://localhost:3306/contatos?useTimezone=true&serverTimezone=UTC", "root", "root");
            CriaBancoDeDados.criaTabela("jdbc:mysql://localhost:3306/contatos?useTimezone=true&serverTimezone=UTC", "root", "root");
    }

}
