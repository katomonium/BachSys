/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.componentes.Painel;
import br.ufla.dcc.ppoo.controller.ComentarioController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.TamanhoMaximoComentario;
import br.ufla.dcc.ppoo.model.Comentario;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.model.Usuario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author aluno
 */
public class TelaComentario extends Tela {

    private JScrollPane painelDeRolagemPrincipal;
    private Painel painelPrincipal;
    private Musica musica;
    private List<Comentario> comentarios;
    private JTextArea novoComentario;
    private JButton btnComentar;
    private JButton btnFechar;
    
    public TelaComentario(String titulo, int x, int y, Musica musica, Tela t) {
        super(titulo, x, y, t);
        this.musica = musica;
        construirTela();
        adicionarAcoes();
    }

    @Override
    protected void construirTela() {
        try {
            atualizarComentarios();
            novoComentario = new JTextArea("");
            novoComentario.setPreferredSize(new Dimension(300, 100));
            novoComentario.setLineWrap(true);
            adicionarComponente(novoComentario, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                                1, 0, 1, 1);
            btnComentar = new JButton("Comentar");
            adicionarComponente(btnComentar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                                2, 0, 1, 1);
            btnFechar = new JButton("Fechar");
            adicionarComponente(btnFechar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                                3, 0, 1, 1);
            
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }

    @Override
    protected void adicionarAcoes() {
        btnComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String comentario = novoComentario.getText();
                    String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    System.out.println(email + ", " + musica.getEmail() + ", " + musica.getNome() + ", " + comentario);
                    ComentarioController.getIntancia().adicionarComentario(email, musica.getEmail(), musica.getNome(), comentario);
                    novoComentario.setText("");
                    atualizarComentarios();
                } catch (ClassNotFoundException | IOException | TamanhoMaximoComentario ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
    }
    
    public void atualizarComentarios() throws IOException, ClassNotFoundException {
            if(painelPrincipal != null) {
                painelPrincipal.removeAll();
                painelPrincipal.setVisible(false);
                painelDeRolagemPrincipal.setVisible(false);
            }    
            String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
            
            comentarios = ComentarioController.getIntancia().getComentariosMusica(musica.getEmail(), musica.getNome());
            
            List<JLabel> lbNomes = gerarLabels();
            List<JTextArea> taComentarios = gerarTxtAreas();
            
            Integer altura = 0;
            Integer largura = 0;
            
            altura = calculaAltura(lbNomes, taComentarios);
            largura = maiorLargura(taComentarios);
            
            painelPrincipal = new Painel(250, altura);
            
            adicionarComponentesPainelPrincipal(lbNomes, taComentarios);
            
            painelDeRolagemPrincipal = new JScrollPane(painelPrincipal);
            painelDeRolagemPrincipal.setPreferredSize(new Dimension(300, 400));
            adicionarComponente(painelDeRolagemPrincipal, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            0, 0, 1, 1);
            
            revalidate();
            painelPrincipal.revalidate();
            painelDeRolagemPrincipal.revalidate();
    }
 
    
    private Integer maiorLargura(List<JTextArea> taComentarios) {
        if(comentarios != null) {
            Integer maior = taComentarios.get(0).getWidth();
            for(JTextArea txtCom : taComentarios) {
                if(maior < txtCom.getWidth()) {
                    maior = txtCom.getWidth();
                }
            }
            return maior;
        } else {
            return 0;
        }
    }

    private List<JLabel> gerarLabels() {
        List<JLabel> lbNomes = new ArrayList<>();
        if(comentarios != null) {
            for(Comentario c : comentarios) {
                JLabel nome = new JLabel(c.getEmailComentarista());
                nome.setPreferredSize(new Dimension(100, 20));
                lbNomes.add(nome);
            }
        }
        return lbNomes;
    }

    private List<JTextArea> gerarTxtAreas() {
        List<JTextArea> txtAreas = new ArrayList<>();
        if(comentarios != null) {
            for(Comentario c : comentarios) {
                JTextArea txtArea = new JTextArea();
                txtArea.setPreferredSize(new Dimension(250, 100));
                txtArea.setLineWrap(true);
                txtArea.setText(c.getComentario());
                txtArea.setEditable(false);
                txtAreas.add(txtArea);
            }
        }
        return txtAreas;
    }
    
    private Integer calculaAltura(List<JLabel> lbNomes, List<JTextArea> taComentarios) {
        Integer altura = 0;
        if(comentarios != null) {
            for(int i = 0; i < comentarios.size(); i++) {
                altura += 20;
                altura += 105;
            }
        }
        return altura;
    }

    private void adicionarComponentesPainelPrincipal(List<JLabel> lbNomes, List<JTextArea> taComentarios) {
        if(comentarios != null) {
            int j = 0;
            for(int i = 0; i < (2 * comentarios.size()); i += 2) {
                painelPrincipal.adicionarComponente(lbNomes.get(j), 
                                        GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                                        i, 0, 1, 1);
                painelPrincipal.adicionarComponente(taComentarios.get(j), 
                                        GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                                        (i + 1), 0, 1, 1);
                j++;
            }
        }
    }
    
}
