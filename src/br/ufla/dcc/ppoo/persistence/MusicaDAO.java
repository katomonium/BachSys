/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface MusicaDAO {
    
    public void adicionarMusica(String chave, Musica m, String email) throws MusicaJaCadastradaException, IOException;
    public void editarMusica(String chave ,Musica m, String email) throws IOException, MusicaNaoEncontradaException, MusicaJaCadastradaException;
    public void remover(String nome, String email) throws IOException, MusicaNaoEncontradaException;
    
    public void salvar() throws IOException;
    
    public int getSize();
    public int getQtdMusicas();
    public int getQtdMusicas(String email);
    
    public Musica getMusica(String nome, String email) throws MusicaNaoEncontradaException;
    public List<Musica> getMusicas(String email);
    public List<Musica> getMusicas();
    public List<Musica> getMusicasPeloNome(String nome);
    public List<Musica> getMusicasPelaTag(String tag);
    
}
