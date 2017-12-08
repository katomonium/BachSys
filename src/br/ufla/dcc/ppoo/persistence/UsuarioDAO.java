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

public class UsuarioDAO extends DAO{
    
//  HashMap de usuarios cadastrados
    private Map<String, Usuario> usuarios;
    
//  Única instância da classe
    private static UsuarioDAO INSTANCIA;
    
    private UsuarioDAO() throws IOException, ClassNotFoundException {
        super("./usuarios.bin");
        FileInputStream fis = new FileInputStream(getNomeArquivo());
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.usuarios = (Map<String, Usuario>) ois.readObject();
        } catch (IOException ioe) {
            usuarios = new HashMap<>();
        }
    }
    
    public void escreverNoArquivo() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new 
        FileOutputStream(getNomeArquivo()));
        oos.writeObject(this.usuarios);
        oos.close();
    }

    public static UsuarioDAO getInstancia() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null){
            INSTANCIA = new UsuarioDAO();
        }
        return INSTANCIA;
    }
    
    public Usuario getUsuario(String email) {
        return this.usuarios.get(email);
    }
    
    public void adicionarUsuario(Usuario u) throws IOException, EmailJaCadastradoException {
        if(this.usuarios.get(u.getEmail()) == null) {
            this.usuarios.put(u.getEmail(), u);
            escreverNoArquivo();
        } else {
            // TODO: Transformar em um throw
            throw new EmailJaCadastradoException();
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
