package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.model.Usuario;
import br.ufla.dcc.ppoo.persistence.UsuarioDAO;

public class UsuarioController {
    
    private static final UsuarioDAO USUARIO_DAO = UsuarioDAO.getInstancia();
    private static final UsuarioController INSTANCIA = new UsuarioController();
    
    // TODO: Usar hash de verdade
    public String hash(String senha) {
        return senha;
    }
    
    public void cadastrar(String nome, String email, String senha) {
               
        senha = this.hash(senha);
        
        Usuario u = new Usuario(nome, email, senha);
        
        USUARIO_DAO.adicionarUsuario(u);
    }
    
    public static UsuarioController getInstancia() {
        return INSTANCIA;
    }
        
}
