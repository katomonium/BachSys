package pongsys.model;

public class Usuario {
    
    private String nome;
	private String email;
	private String senha; 
    
    /**
     * Construtor do Usuário
     * 
     * @param nome
     * @param email
     * @param senha 
     */
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    
}
