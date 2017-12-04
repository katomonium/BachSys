package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.model.Usuario;
import br.ufla.dcc.ppoo.persistence.MusicaDAO;
import java.util.List;

public class MusicaController {
    
    private static final MusicaDAO MUSICA_DAO = MusicaDAO.getINSTANCIA();
    private static final MusicaController INSTANCIA = new MusicaController();
    
    public void addMusica(String nome, String autor, String album,
            int ano, String genero, Usuario usuario, String[] tags) {
        
        MUSICA_DAO.addMusica(
                new Musica(nome, autor, album, ano, genero, usuario, tags)
        );
    }

    public static MusicaController getInstancia() {
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
    
}
