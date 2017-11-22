package br.ufla.dcc.ppoo.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufla.dcc.ppoo.model.Usuario;

public class UsuarioDAO {
    
//  Lista de usuarios cadastrados
    private final List<Usuario> usuarios;
    
//  Única instância da classe
    private static UsuarioDAO instancia;
    
    private UsuarioDAO() {
        this.usuarios = new ArrayList();
    }

    public static UsuarioDAO getInstancia() {
        return instancia;
    }
    
    public Usuario getUsuario(String email) {
        for(Usuario u : this.usuarios) {
            if(email.equals(u.getEmail())) {
                return u;
            }
        }
        
        return null;
    }
    
    public void adicionarUsuario(Usuario u) {
        this.usuarios.add(u);
    }
}
