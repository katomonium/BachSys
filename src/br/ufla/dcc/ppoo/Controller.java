package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.model.Usuario;
import java.util.List;
import java.util.ArrayList;

public class Controller {
    
    private List<Usuario> usuarios;

    public Controller() {
        this.usuarios = new ArrayList<>();
    }
    
    public void cadastrarUsuario(String nome, String email, String senha) {
        this.usuarios.add(new Usuario(nome, email, senha));
    }
    
}
