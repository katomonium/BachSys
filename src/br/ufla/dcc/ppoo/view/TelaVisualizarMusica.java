/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.componentes.Painel;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TelaVisualizarMusica extends Tela {

    private JLabel lbNome;
    private JLabel lbAutor;
    private JLabel lbAlbum;
    private JLabel lbAno;
    private JLabel lbGenero;
    private JLabel lbTags;
    private JLabel lbUsuario;
    private JTextArea lbValorNome;
    private JTextArea lbValorAutor;
    private JTextArea lbValorAlbum;
    private JTextArea lbValorAno;
    private JTextArea lbValorGenero;
    private JTextArea lbValorTags;
    private JTextArea lbValorUsuario;
    
    private JButton btnEditar;
    private JButton btnAvaliar;
    private JButton btnComentar;
    private JButton btnAdicionar;
    private JButton btnFechar;
    
    private Musica musica;

    private Boolean editou;
    private Boolean avaliou;
    private boolean adicionou;
    
    public TelaVisualizarMusica(Musica musica, Tela t) {
        super(musica.getNome(), 350, 450, t);
        editou = false;
        avaliou = false;
        adicionou = false;
        this.musica = musica;
        
        construirTela();
        adicionarAcoes();
        
        try {
            if(UsuarioController.getInstancia().getEmailUsuarioLogado().equals(musica.getEmail())) {
                adicionarBotaoEditar();
            } else {
                adicionarBotaoAvaliar();
                adicionarBotaoAdicionar();
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        pack();
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
        
        lbValorNome = new JTextArea();
        lbValorAutor = new JTextArea();
        lbValorAlbum = new JTextArea();
        lbValorAno = new JTextArea();
        lbValorGenero = new JTextArea();
        lbValorTags = new JTextArea();
        lbValorUsuario = new JTextArea();
        
        
        adicionarComponente(lbNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 0, 0, 1, 1);
        adicionarComponente(lbAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 0, 1, 1);
        adicionarComponente(lbAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 2, 0, 1, 1);
        adicionarComponente(lbAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 0, 1, 1);
        adicionarComponente(lbGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 4, 0, 1, 1);
        adicionarComponente(lbTags, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 5, 0, 1, 1);
        adicionarComponente(lbUsuario, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 6, 0, 1, 1);
        
        btnComentar = new JButton("Comentar");
        btnFechar = new JButton("Fechar");
        
        adicionarComponente(btnComentar, GridBagConstraints.EAST, 
                            GridBagConstraints.HORIZONTAL, 8, 0, 1, 1);
        adicionarComponente(btnFechar, GridBagConstraints.EAST, 
                    GridBagConstraints.HORIZONTAL, 9, 0, 1, 1);
        
        adicionarComponente(lbValorNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 0, 1, 1, 1);
        adicionarComponente(lbValorAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 1, 1, 1);
        adicionarComponente(lbValorAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 2, 1, 1, 1);
        adicionarComponente(lbValorAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 1, 1, 1);
        adicionarComponente(lbValorGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 4, 1, 1, 1);
        adicionarComponente(lbValorTags, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 5, 1, 1, 1);
        adicionarComponente(lbValorUsuario, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 6, 1, 1, 1);
        
        
//        adicionarComponente(pr, GridBagConstraints.EAST, 
//                    GridBagConstraints.HORIZONTAL, 1, 0, 1, 1);
        
        adicionarValores();
    }
    
    private void adicionarValores() {
        
        if(musica == null) {
            return;
        }
        lbValorNome.setText(musica.getNome());
        try {
            lbValorUsuario.setText(
                    UsuarioController.getInstancia().getUsuario(musica.getEmail()).getNome()
            );
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        lbValorAlbum.setText(musica.getAlbum());
        lbValorAno.setText(Integer.toString(musica.getAno()));
        lbValorAutor.setText(musica.getAutor());
        String[] aux = musica.getTags();
        String concatenacaoTags = "";
        if(aux != null && aux.length > 0){
            for(int i = 0; i < aux.length - 1; i++) {
                concatenacaoTags += aux[i] + " ";
            }
            concatenacaoTags += aux[aux.length - 1];
        }
        lbValorTags.setText(concatenacaoTags);
        
        lbValorGenero.setText(musica.getGenero());
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
        adicionarComponente(btnEditar, GridBagConstraints.WEST, 
                    GridBagConstraints.HORIZONTAL, 8, 1, 1, 1);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaEditarMusica tem = new TelaEditarMusica(musica.getNome(), musica, t);
                tem.setVisible(true);
                tem.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        musica = tem.getMusica();
                        editou = true;
                        adicionarValores();
                    }
                });
            }
        });
    } 

    public boolean musicaAlterada() {
        return editou;
    }
    public boolean musicaAvaliada() {
        return avaliou;
    }
    public boolean musicaAdicionada() {
        return adicionou;
    }
    
    private void adicionarBotaoAvaliar() {
        Tela t = this;
        btnAvaliar = new JButton("Avaliar");
        adicionarComponente(btnAvaliar, GridBagConstraints.WEST, 
                    GridBagConstraints.HORIZONTAL, 8, 1, 1, 1);
        btnAvaliar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaAvaliarMusica tam = new TelaAvaliarMusica(musica.getNome(), musica, t);
                tam.setVisible(true);
                tam.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        musica = tam.getMusica();
                        avaliou = true;
                        adicionarValores();
                    }
                });
            }
        });
    }
    
    
    private void adicionarBotaoAdicionar() {
        Tela t = this;
        btnAdicionar = new JButton("Adicionar");
        adicionarComponente(btnAdicionar, GridBagConstraints.EAST, 
                    GridBagConstraints.HORIZONTAL, 9, 1, 1, 1);
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    MusicaController.getInstancia().adicionarMusica(musica.getNome(), musica.getNome(), musica.getAutor(), 
                                                            musica.getAlbum(), musica.getAno(), musica.getGenero(),
                                                            email, musica.getTags());
                    adicionou = true;
                    setVisible(false);
                } catch (MusicaJaCadastradaException | IOException | ClassNotFoundException | CampoVazioException | CampoMinimoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
