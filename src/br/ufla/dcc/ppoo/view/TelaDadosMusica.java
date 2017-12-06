/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.componentes.Painel;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class TelaDadosMusica extends Tela {
    
    private Painel painel;
    
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
    
    private Musica musica;

    public TelaDadosMusica(Musica musica, Tela t) {
        super(musica.getNome(), 350, 450, t);
        painel = null;
        this.musica = musica;
        
        construirTela();
        adicionarAcoes();
        
        if(UsuarioController.getInstancia().getEmailUsuarioLogado().equals(musica.getEmail())) {
            adicionarBotaoEditar();
        }
    }

    
    @Override
    protected void construirTela() {
        lbNome = new JLabel("Nome:");
        lbUsuario = new JLabel("Usuario:");
        lbAlbum = new JLabel("Album:");
        lbAno = new JLabel("Ano:");
        lbAutor = new JLabel("Autor:");
        lbGenero = new JLabel("Gênero:");
        lbTags = new JLabel("Tags:");
        
        
        
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
        
        btnComentar = new JButton("Comentar");
        btnFechar = new JButton("Fechar");
        
        adicionarComponente(btnComentar, GridBagConstraints.EAST, 
                            GridBagConstraints.HORIZONTAL, 8, 0, 1, 1);
        adicionarComponente(btnFechar, GridBagConstraints.EAST, 
                    GridBagConstraints.HORIZONTAL, 9, 0, 1, 1);
        
        adicionarValores();
    }
    
    private void adicionarValores() {
        if(painel != null) {
            remove(painel);
        }
        
        painel = new Painel(100, 200);
        
        lbValorNome = new JLabel(musica.getNome());
        lbValorUsuario = new JLabel(
                            UsuarioController.getInstancia().getUsuario(musica.getEmail()).getNome()
                        );
        lbValorAlbum = new JLabel(musica.getAlbum());
        lbValorAno = new JLabel(Integer.toString(musica.getAno()));
        lbValorAutor = new JLabel(musica.getAutor());
        String[] aux = musica.getTags();
        String concatenacaoTags = "";
        for(int i = 0; i < aux.length - 1; i++) {
            concatenacaoTags += aux[i] + " ";
        }
        concatenacaoTags += aux[aux.length - 1];
        
        lbValorTags = new JLabel(concatenacaoTags);
        
        lbValorGenero = new JLabel(musica.getGenero());
        
        painel.adicionarComponente(lbValorNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 0, 1, 1, 1);
        painel.adicionarComponente(lbValorAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 1, 1, 1);
        painel.adicionarComponente(lbValorAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 2, 1, 1, 1);
        painel.adicionarComponente(lbValorAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 1, 1, 1);
        painel.adicionarComponente(lbValorGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 4, 1, 1, 1);
        painel.adicionarComponente(lbValorTags, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 5, 1, 1, 1);
        painel.adicionarComponente(lbValorUsuario, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 6, 1, 1, 1);
        
        adicionarComponente(painel, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 1, 1, 7);
        this.revalidate();
    }

    @Override
    protected void adicionarAcoes() {
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        
        btnComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: Comentar
            }
        });
        
    }
    
    private void adicionarBotaoEditar() {
        Tela t = this;
        btnEditar = new JButton("Editar");
        adicionarComponente(btnEditar, GridBagConstraints.EAST, 
                    GridBagConstraints.NONE, 0, 0, 2, 1);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaEditarMusica tem = new TelaEditarMusica(musica, t);
                tem.setVisible(true);
                tem.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        adicionarValores();
                    }
                });
            }
        });
    } 
}
