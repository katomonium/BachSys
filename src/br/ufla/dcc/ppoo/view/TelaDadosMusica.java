/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.componentes.Painel;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
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

/**
 *
 * @author dell
 */
public class TelaDadosMusica extends Tela {

//    private JLabel lbNome;
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

    private Boolean editou;
    
    public TelaDadosMusica(Musica musica, Tela t) {
        super(musica.getNome(), t);
        editou = false;
        this.musica = musica;
        
        construirTela();
        adicionarAcoes();
        pack();
        
        try {
            if(UsuarioController.getInstancia().getEmailUsuarioLogado().equals(musica.getEmail())) {
                adicionarBotaoEditar();
            }
        } catch (IOException ex) {
            Logger.getLogger(TelaDadosMusica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaDadosMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void construirTela() {
//        lbNome = new JLabel("Nome:");
        lbUsuario = new JLabel("Usuario:");
        lbAlbum = new JLabel("Album:");
        lbAno = new JLabel("Ano:");
        lbAutor = new JLabel("Autor:");
        lbGenero = new JLabel("Gênero:");
        lbTags = new JLabel("Tags:");
        
        lbValorNome = new JLabel();
        lbValorAutor = new JLabel();
        lbValorAlbum = new JLabel();
        lbValorAno = new JLabel();
        lbValorGenero = new JLabel();
        lbValorTags = new JLabel();
        lbValorUsuario = new JLabel();
        
//        adicionarComponente(lbNome, GridBagConstraints.WEST, 
//                            GridBagConstraints.NONE, 1, 0, 1, 1);
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
        
        adicionarComponente(lbValorNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 0, 2, 1, 2, 5, 5, 10);
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
        
        adicionarValores();
    }
    
    private void adicionarValores() {
        
        if(musica == null) {
            return;
        }
        
        lbValorNome.setText("<html><body><h2>" + musica.getNome() + "</h2></body></html>");
//        lbValorNome.setText(musica.getNome());
        System.out.println(musica.getEmail());
        try {
            lbValorUsuario.setText(
                    UsuarioController.getInstancia().getUsuario(musica.getEmail()).getNome()
            );
        } catch (IOException ex) {
            Logger.getLogger(TelaDadosMusica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaDadosMusica.class.getName()).log(Level.SEVERE, null, ex);
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

        System.out.println(lbValorGenero.getText());
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
                        try {
                            musica = MusicaController.getInstancia().getMusica(musica.getNome(), musica.getEmail());
                        } catch (IOException ex) {
                            Logger.getLogger(TelaDadosMusica.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(TelaDadosMusica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        editou = true;
                        adicionarValores();
                    }
                });
            }
        });
    } 

    boolean musicaAlterada() {
        return editou;
    }
}
