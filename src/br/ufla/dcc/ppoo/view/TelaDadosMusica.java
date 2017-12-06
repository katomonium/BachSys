/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
import java.awt.GridBagConstraints;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class TelaDadosMusica extends Tela {
    
    private JLabel lbNome;
    private JLabel lbAutor;
    private JLabel lbAlbum;
    private JLabel lbAno;
    private JLabel lbGenero;
    private JLabel lbTags;
    private JLabel lbUsuario;
    private JLabel lbValorNome;
    private JLabel lbValorAutor;
    private JLabel lbValorAlbum;
    private JLabel lbValorAno;
    private JLabel lbValorGenero;
    private JLabel lbValorTags;
    private JLabel lbValorUsuario;
    
    private JButton btnEditar;
    private JButton btnComentar;
    private JButton btnFechar;

    public TelaDadosMusica(Musica musica, Tela t) {
        super(musica.getNome(), 350, 450, t);
        
        construirTela(musica);
        System.out.println(Arrays.toString(musica.getTags()));
    }

    
    
    protected void construirTela(Musica musica) {
        lbNome = new JLabel("Nome:");
        lbValorNome = new JLabel(musica.getNome());
        
        lbUsuario = new JLabel("Usuario:");
        lbValorUsuario = new JLabel(
                UsuarioController.getInstancia().getUsuario(musica.getEmail()).getNome()
        );
        
        lbAlbum = new JLabel("Album:");
        lbValorAlbum = new JLabel(musica.getAlbum());
        
        lbAno = new JLabel("Ano:");
        lbValorAno = new JLabel(Integer.toString(musica.getAno()));
        
        lbAutor = new JLabel("Autor:");
        lbValorAutor = new JLabel(musica.getAutor());
        
        lbGenero = new JLabel("Gênero:");
        lbValorGenero = new JLabel(musica.getGenero());
        
        lbTags = new JLabel("Tags:");
        lbValorTags = new JLabel(Arrays.toString(musica.getTags()));
        
        adicionarComponente(lbNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 0, 1, 1);
        adicionarComponente(lbAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 2, 0, 1, 1);
        adicionarComponente(lbAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 0, 1, 1);
        adicionarComponente(lbAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 4, 0, 1, 1);
        adicionarComponente(lbGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 5, 0, 1, 1);
        adicionarComponente(lbTags, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 6, 0, 1, 1);
        adicionarComponente(lbUsuario, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 7, 0, 1, 1);
        
        adicionarComponente(lbValorNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 1, 1, 1);
        adicionarComponente(lbValorAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 2, 1, 1, 1);
        adicionarComponente(lbValorAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 1, 1, 1);
        adicionarComponente(lbValorAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 4, 1, 1, 1);
        adicionarComponente(lbValorGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 5, 1, 1, 1);
        adicionarComponente(lbValorTags, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 6, 1, 1, 1);
        adicionarComponente(lbValorUsuario, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 7, 1, 1, 1);
        
        btnComentar = new JButton("Comentar");
        btnEditar = new JButton("Editar");
        btnFechar = new JButton("Fechar");
        
        
        adicionarComponente(btnComentar, GridBagConstraints.EAST, 
                            GridBagConstraints.HORIZONTAL, 8, 0, 1, 1);
        adicionarComponente(btnFechar, GridBagConstraints.EAST, 
                    GridBagConstraints.HORIZONTAL, 9, 0, 1, 1);
        
        adicionarComponente(btnEditar, GridBagConstraints.EAST, 
                    GridBagConstraints.NONE, 0, 0, 2, 1);
        
    }

    @Override
    protected void adicionarAcoes() {
        
    }

    @Override
    protected void construirTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
