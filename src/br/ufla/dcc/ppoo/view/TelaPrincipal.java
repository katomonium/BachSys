package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;


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
        painelAcoes = new Painel(150, 350);
        painelAcoes.setBackground(Color.yellow);
        adicionarComponente(painelAcoes, GridBagConstraints.WEST, GridBagConstraints.NONE, 1, 0, 1, 1);
        painelDadosUsuario = new Painel(150, 200);
        painelDadosUsuario.setBackground(Color.white);
        adicionarComponente(painelDadosUsuario, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 1, 1);
        painelListaMusica = new Painel(600, 550);
        adicionarComponente(painelListaMusica, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 1, 1, 2);
        painelListaMusica.setBackground(Color.red);
        
        if(UsuarioController.getInstancia().estaLogado()) {
            // Adicionar os dados do usuario na tabela
            String nome = UsuarioController.getInstancia().getNomeUsuarioLogado();
            String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
            Integer qtdMusicas = UsuarioController.getInstancia().getQtdMusicas();
            JLabel lbNome = new JLabel("Bem vindo, " + nome);
            JLabel lbEmail = new JLabel("Email: " + email);
            JLabel lbQtdMusica = new JLabel("<html><body>Quantidade de"
                                            + " músicas cadastradas: " + qtdMusicas + "</body></html>");
            
            
            painelDadosUsuario.adicionarComponente(lbNome, GridBagConstraints.CENTER, 
                                        GridBagConstraints.HORIZONTAL, 0, 0, 1, 1);
            painelDadosUsuario.adicionarComponente(lbEmail, GridBagConstraints.CENTER, 
                                        GridBagConstraints.HORIZONTAL, 1, 0, 1, 1);
            painelDadosUsuario.adicionarComponente(lbQtdMusica, GridBagConstraints.CENTER, 
                                        GridBagConstraints.HORIZONTAL, 2, 0, 1, 4);
            
            
            JButton btnAdicionarMusica = new JButton("Adicionar");
            btnAdicionarMusica.setToolTipText("Adicionar uma musica ao catalogo");
            painelAcoes.adicionarComponente(btnAdicionarMusica, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, 0);
            
            
            JButton btnEditarMusica = new JButton("Editar");
            btnEditarMusica.setToolTipText("Editar musicas do catalogo");
            
            painelAcoes.adicionarComponente(btnEditarMusica, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 1, 0, 1, 1, 0.5, 0);
            
            JButton btnRemoverMusica = new JButton("Remover");
            btnRemoverMusica.setToolTipText("Remover mussicas do catalogo");
            painelAcoes.adicionarComponente(btnRemoverMusica, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 2, 0, 1, 1, 0.5, 0);
            
            
        }
        
        
        
        
        JButton b1 = new JButton("TESTE1");
        JButton b2 = new JButton("TESTE2");
        JButton b3 = new JButton("TESTE3");
        
        painelListaMusica.adicionarComponente(b1, GridBagConstraints.WEST, 
                                                GridBagConstraints.CENTER, 0, 1, 1, 1);
        painelListaMusica.adicionarComponente(b2, GridBagConstraints.WEST, 
                                                GridBagConstraints.CENTER, 0, 2, 1, 1);
        painelListaMusica.adicionarComponente(b3, GridBagConstraints.WEST, 
                                                GridBagConstraints.CENTER, 0, 3, 1, 1);


    }

    @Override
    protected void adicionarAcoes() {
        
    }
    
}
