package br.ufla.dcc.ppoo.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufla.dcc.ppoo.model.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {
    
//  HashMap de usuarios cadastrados
    private final Map<String, Usuario> usuarios;
    
//  Única instância da classe
    private static final UsuarioDAO INSTANCIA = new UsuarioDAO();
    
    private UsuarioDAO() {
        this.usuarios = new HashMap<>();
    }

    public static UsuarioDAO getInstancia() {
        return INSTANCIA;
    }
    
    public Usuario getUsuario(String email) {
        return this.usuarios.get(email);
    }
    
    public void adicionarUsuario(Usuario u) {
        if(this.usuarios.get(u.getEmail()) == null ) {
            this.usuarios.put(u.getEmail(), u);
        } else {
            // TODO: Transformar em um throw
            System.out.println("ERRO: Usuário já cadastrado");
        }
    }
    
    public void visualizaUsuarios() {
        System.out.println("visualizaUsuarios()");
        
        for(Map.Entry m : this.usuarios.entrySet()) {
            System.out.println(m.getValue());
        }
        
        System.out.println("");
    }
}
