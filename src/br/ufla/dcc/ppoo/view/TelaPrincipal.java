package br.ufla.dcc.ppoo.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JButton;


public class TelaPrincipal extends Tela {
    
    private Painel painelDadosUsuario;
    private Painel painelAcoes;
    private Painel painelListaMusica;
    
    public TelaPrincipal(Tela t) {
        super("BachSys", 800, 600, t);
        construirTela();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    protected void construirTela() {
        painelAcoes = new Painel(200, 325);
        painelAcoes.setBackground(Color.yellow);
        adicionarComponente(painelAcoes, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 0, 1, 1);
        painelDadosUsuario = new Painel(200, 225);
        painelDadosUsuario.setBackground(Color.blue);
        adicionarComponente(painelDadosUsuario, GridBagConstraints.WEST,
                            GridBagConstraints.NONE, 0, 0, 1, 1);
        painelListaMusica = new Painel(550, 550);
        painelListaMusica.setBackground(Color.red);
        adicionarComponente(painelListaMusica, GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH, 0, 1, 1, 2);
        
        
        JButton b1 = new JButton("TESTE1");
        JButton b2 = new JButton("TESTE2");
        JButton b3 = new JButton("TESTE3");
        
        painelAcoes.adicionarComponente(b1, GridBagConstraints.NORTH,
                            GridBagConstraints.NONE, 0, 0, 1, 1);
        painelDadosUsuario.adicionarComponente(b2, GridBagConstraints.SOUTH,
                            GridBagConstraints.NONE, 0, 0, 1, 1);
        painelListaMusica.adicionarComponente(b3, GridBagConstraints.SOUTH,
                            GridBagConstraints.NONE, 2, 1, 1, 1);
        
    }

    @Override
    protected void adicionarAcoes() {
        System.out.println("deu rui");
    }
    
}
