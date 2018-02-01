package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.exceptions.EmailJaCadastradoException;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.model.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UsuarioDAO {
    
    public void escreverNoArquivo() throws IOException;
    public Usuario getUsuario(String email);
    public void adicionarUsuario(Usuario u) throws IOException, EmailJaCadastradoException;
    
}
