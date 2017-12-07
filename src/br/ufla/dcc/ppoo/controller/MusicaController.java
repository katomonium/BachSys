package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.persistence.MusicaDAO;
import java.io.IOException;
import java.util.List;

public class MusicaController {
    
    private static MusicaDAO MUSICA_DAO;
    private static MusicaController INSTANCIA;
    
    private MusicaController() throws IOException, ClassNotFoundException{
        MUSICA_DAO = MusicaDAO.getINSTANCIA();
    }
    
    public void addMusica(String nome, String autor, String album,
            Integer ano, String genero, String usuario, String[] tags) throws IOException, MusicaJaCadastradaException {
        
        MUSICA_DAO.addMusica(
                new Musica(nome, autor, album, ano, genero, usuario, tags), usuario
        );
    }

    public static MusicaController getInstancia() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null){
            INSTANCIA = new MusicaController();
        }
        return INSTANCIA;
    }
    
    public int getQtdMusicas() {
        return MUSICA_DAO.getQtdMusicas();
    }
    
    public int getQtdMusicas(String email) {
        return MUSICA_DAO.getQtdMusicas(email);
    }
    
    public List<Musica> getMusicas(String email) {
        return MUSICA_DAO.getMusicas(email);
    }
    
    public List<Musica> getMusicas() {
        return MUSICA_DAO.getMusicas();
    }
    
    public void modificarMusica(String nome, String autor, String album,
            int ano, String genero, String usuario, String[] tags) {
        
        MUSICA_DAO.editarMusica(
            new Musica(nome, autor, album, ano, genero, usuario, tags), usuario
        );
    }

    public Musica getMusica(String nome, String email) {
        return MUSICA_DAO.getMusica(nome, email);
    }
    
}
