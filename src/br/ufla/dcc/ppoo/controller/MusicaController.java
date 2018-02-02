package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaAvaliadaException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.persistence.MusicaDAO;
import br.ufla.dcc.ppoo.persistence.MusicaDAOArquivo;
import java.io.IOException;
import java.util.List;

public class MusicaController {
    
    private static MusicaDAO MUSICA_DAO;
    private static MusicaController INSTANCIA;
    
    private MusicaController() throws IOException, ClassNotFoundException{
        MUSICA_DAO = MusicaDAOArquivo.getINSTANCIA();
        
    }
    
    public void adicionarMusica(String chave, String nome, String autor, String album,
            Integer ano, String genero, String usuario, String[] tags) throws IOException, 
            MusicaJaCadastradaException, CampoVazioException, CampoMinimoException {
        
        
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
        
        
        MUSICA_DAO.adicionarMusica(chave, 
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
        List<Musica> musicas = MUSICA_DAO.getMusicas(email);
        musicas = this.ordenarPeloNomeCrescente(musicas);
        
        return musicas;
    }
    
    public List<Musica> getMusicas() {
        List<Musica> musicas = MUSICA_DAO.getMusicas();
        musicas = this.ordenarPeloNomeCrescente(musicas);
        
        return musicas;
    }
    
    public void modificarMusica(String chave, String nome, String autor, String album,
            Integer ano, String genero, String usuario, String[] tags) throws IOException, 
            CampoVazioException, CampoMinimoException, MusicaNaoEncontradaException, 
            MusicaJaCadastradaException {
        
        
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

    public Musica getMusica(String nome, String email) throws MusicaNaoEncontradaException {
        return MUSICA_DAO.getMusica(nome, email);
    }

    public void removerMusica(String nome, String email) throws IOException,
                                ClassNotFoundException, MusicaNaoEncontradaException {
        
        MUSICA_DAO.remover(nome, email);
    }
    
    
    private List<Musica> ordenarPeloNomeCrescente(List<Musica> musicas) {
        int posMenor;
        for(int i = 0; i < musicas.size() - 1; i++) {
            posMenor = i;
            for(int j = i + 1; j < musicas.size(); j++) {
                String nomeJ = musicas.get(j).getNome();
                String nomeMenor = musicas.get(posMenor).getNome();
                if(nomeJ.compareToIgnoreCase(nomeMenor) < 0) {
                    posMenor = j;
                }
            }
            Musica aux = musicas.get(posMenor);
            musicas.set(posMenor, musicas.get(i));
            musicas.set(i, aux);
        }
        return musicas;
    }
    
    private List<Musica> ordenarPelaNotaDecrescente(List<Musica> musicas) {
        int posMaior;
        for(int i = 0; i < musicas.size() - 1; i++) {
            posMaior = i;
            for(int j = i + 1; j < musicas.size(); j++) {
                int notaJ = musicas.get(j).getPontos();
                int notaMaior = musicas.get(posMaior).getPontos();
                if(notaJ > notaMaior) {
                    posMaior = j;
                }
            }
            Musica aux = musicas.get(posMaior);
            musicas.set(posMaior, musicas.get(i));
            musicas.set(i, aux);
        }
        return musicas;
    }

    public List<Musica> buscarMusicas(String palavraChave) throws CampoVazioException, MusicaNaoEncontradaException {
        if(palavraChave.equals("")) {
            throw new CampoVazioException("busca");
        }
        List<Musica> m1 = MUSICA_DAO.getMusicasPeloNome(palavraChave);
        List<Musica> m2 = MUSICA_DAO.getMusicasPelaTag(palavraChave);
        for (int i = 0; i < m2.size(); i++) {
            if(!m1.contains(m2.get(i))) {
                m1.add(m2.get(i));
            }
        }
        if(m1.size() == 0) {
            throw new MusicaNaoEncontradaException();
        }
        m1 = ordenarPelaNotaDecrescente(m1);
        return m1;    
    }
    
    public void adicionarPontos(String email, Musica musica, Integer pontosAdicionados) throws MusicaJaAvaliadaException, IOException {
        musica.adicionarPontos(email, pontosAdicionados);
        MUSICA_DAO.salvar();
    }
    
    
}
