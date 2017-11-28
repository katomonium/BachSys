package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.model.Usuario;
import br.ufla.dcc.ppoo.persistence.MusicaDAO;

public class MusicaController {
    
    private static final MusicaDAO MUSICA_DAO = MusicaDAO.getINSTANCIA();
    private static final MusicaController INSTANCIA = new MusicaController();
    
    public void addMusica(String nome, String autor, String album,
            int ano, String genero, Usuario usuario, String[] tags) {
        
        MUSICA_DAO.addMusica(
                new Musica(nome, autor, album, ano, genero, usuario, tags)
        );
    }
    
    public Musica getMusica(String nome) {
        return MUSICA_DAO.getMusica(nome);
    }
    
}
