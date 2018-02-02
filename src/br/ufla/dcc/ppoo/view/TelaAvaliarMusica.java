/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.MusicaJaAvaliadaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class TelaAvaliarMusica extends Tela {

    
    Musica musica;
    JComboBox pontos;
    JButton btnConfirmar;
    JButton btnCancelar;
    
    public TelaAvaliarMusica(String nomeMusica, Musica musica, Tela t) {
        super("Avaliar", 300, 200, t);
        this.musica = musica;
        construirTela();
        adicionarAcoes();
    }
    
    public Musica getMusica() {
        return this.musica;
    }

    @Override
    protected void construirTela() {
        Integer vetor[] = {1, 2, 3, 4, 5};
        pontos = new JComboBox(vetor);
        
        btnConfirmar = new JButton("Confirmar");
        btnCancelar = new JButton("Cancelar");
        
        adicionarComponente(pontos, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            0, 0, 1, 1);
        
        adicionarComponente(btnCancelar, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                            1, 0, 1, 1);
        
        adicionarComponente(btnConfirmar, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                            1, 1, 1, 1);
    }

    @Override
    protected void adicionarAcoes() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    Integer pontosAdicionados = (Integer) pontos.getSelectedItem();
                    System.out.println(email);
                    MusicaController.getInstancia().adicionarPontos(email, musica, pontosAdicionados);
                    setVisible(false);
                } catch (IOException | ClassNotFoundException | MusicaJaAvaliadaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
    
}
