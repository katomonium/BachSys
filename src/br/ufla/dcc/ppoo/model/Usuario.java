package br.ufla.dcc.ppoo.model;

import java.io.Serializable;

public class Usuario implements Serializable{
    
    private final String nome;
    private final String email;
    private final String senha;
    
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

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
    
}
