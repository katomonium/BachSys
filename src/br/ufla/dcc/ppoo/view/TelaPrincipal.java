package br.ufla.dcc.ppoo.view;

import javax.swing.JPanel;


public class TelaPrincipal extends Tela {
    
    private JPanel painelDadosUsuario;
    private JPanel painelAcoes;
    private JPanel painelListaMusica;
    
    public TelaPrincipal() {
        super("BachSys", 800, 600);
        construirTela();
        
        painelAcoes = new JPanel();
        painelDadosUsuario = new JPanel();
        painelListaMusica = new JPanel();
    }
    
    @Override
    protected void construirTela() {
        
    }

    @Override
    protected void adicionarAcoes() {
        
    }
    
}
