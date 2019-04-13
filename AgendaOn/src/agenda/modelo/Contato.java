package agenda.modelo;

public class Contato {
	   private String nome, telefone;
       private int id;

       public Contato(String nome, String telefone) {
               super();
               this.nome = nome;
               this.telefone = telefone;
       }

       public Contato(String nome, String telefone, int id) {
               super();
               this.nome = nome;
               this.telefone = telefone;
               this.id = id;
       }

       public int getId() {
               return id;
       }

       public String getNome() {
               return nome;
       }

       public void setNome(String nome) {
               this.nome = nome;
       }

       public String getTelefone() {
               return telefone;
       }

       public void setTelefone(String telefone) {
               this.telefone = telefone;
       }
}
