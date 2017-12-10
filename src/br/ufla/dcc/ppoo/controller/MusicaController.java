package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
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
    
    public void addMusica(String chave, String nome, String autor, String album,
            Integer ano, String genero, String usuario, String[] tags) throws IOException, MusicaJaCadastradaException, CampoVazioException, CampoMinimoException {
        if(nome.equals("")){
            throw new CampoVazioException("nome");
        }
        if(autor.equals("")){
            throw new CampoVazioException("autor");
        }
        if(album.equals("")){
            throw new CampoVazioException("album");
        }
        if(ano == null){
            throw new CampoVazioException("ano");
        }
        if(genero.equals("")){
            throw new CampoVazioException("gênero");
        }
        if(tags.length < 2){
            throw new CampoMinimoException("tags", 2);
        }
        MUSICA_DAO.addMusica(chave, 
                new Musica(nome, autor, album, ano, genero, usuario, tags), usuario);
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
    
    public void modificarMusica(String chave, String nome, String autor, String album,
            Integer ano, String genero, String usuario, String[] tags) throws IOException, CampoVazioException, CampoMinimoException, MusicaNaoEncontradaException {
        if(nome.equals("")) {
            throw new CampoVazioException("nome");
        }
        if(autor.equals("")) {
            throw new CampoVazioException("autor");
        }
        if(album.equals("")) {
            throw new CampoVazioException("album");
        }
        if(ano == null) {
            throw new CampoVazioException("ano");
        }
        if(genero.equals("")) {
            throw new CampoVazioException("gênero");
        }
        if(tags.length < 2) {
            throw new CampoMinimoException("tags", 2);
        }
        MUSICA_DAO.editarMusica(chave, 
            new Musica(nome, autor, album, ano, genero, usuario, tags), usuario);
    }

    public Musica getMusica(String nome, String email) {
        return MUSICA_DAO.getMusica(nome, email);
    }

    public void removerMusica(String nome, String email) throws IOException, ClassNotFoundException, MusicaNaoEncontradaException {
        MUSICA_DAO.remover(nome, email);
    }
    
}
