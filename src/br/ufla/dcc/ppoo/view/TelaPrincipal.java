package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TelaPrincipal extends Tela {
    
    private Painel painelDadosUsuario;
    private Painel painelAcoes;
    private Painel painelListaMusica;
    private JButton btnAdicionarMusica;
    private JButton btnEditarMusica;
    private JButton btnRemoverMusica;
    private JButton btnLogout;
    private JButton btnSair;
    
    public TelaPrincipal(Tela t) {
        super("BachSys", 800, 600, t);
        construirTela();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        

        
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
                                        GridBagConstraints.HORIZONTAL, 2 , 0, 1, 4);
            
            
            btnAdicionarMusica = new JButton("Adicionar");
            btnAdicionarMusica.setToolTipText("Adicionar uma musica ao catalogo");
            painelAcoes.adicionarComponente(btnAdicionarMusica, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, 0);
            
            
            btnEditarMusica = new JButton("Editar");
            btnEditarMusica.setToolTipText("Editar musicas do catalogo");
            
            painelAcoes.adicionarComponente(btnEditarMusica, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 1, 0, 1, 1, 0.5, 0);
            
            btnRemoverMusica = new JButton("Remover");
            btnRemoverMusica.setToolTipText("Remover mussicas do catalogo");
            painelAcoes.adicionarComponente(btnRemoverMusica, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 2, 0, 1, 1, 0.5, 0);
            
            btnLogout = new JButton("Logout");
            btnLogout.setToolTipText("Fazer Logout do sistema");
            painelAcoes.adicionarComponente(btnLogout, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 3, 0, 1, 1, 0.5, 0);
            
            btnSair = new JButton("Sair");
            btnSair.setToolTipText("Fazer logout e finalizar o programa");
            painelAcoes.adicionarComponente(btnSair, GridBagConstraints.CENTER,
                                            GridBagConstraints.HORIZONTAL, 4, 0, 1, 1, 0.5, 0);
            
            adicionarAcoes();
            
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
        btnAdicionarMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: Chamar janela de cadastro de musicas
            }
        });
        btnEditarMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: Abrir janela de edicao de musica
            }
        });
        btnRemoverMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO: Remover item
            }
        });
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(UsuarioController.getInstancia().estaLogado()) {
                    Integer opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente realizar logout?", "Realizar logout?",
                                                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    
                    if(opcao == JOptionPane.YES_OPTION) {
                        getTelaAnterior().setVisible(true);
                        UsuarioController.getInstancia().finalizarSessao();
                        setVisible(false);
                    }
                }
            }
        });
        
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                confirmarSaida();
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                confirmarSaida();
            }
            
        });
    }
    
    public Integer confirmarSaida() {
        Integer opcao = JOptionPane.showConfirmDialog(null, "Desja realizar login em outra conta?", "Realizar novo login?",
                                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        switch (opcao) {
            case JOptionPane.NO_OPTION:
                UsuarioController.getInstancia().finalizarSessao();
                System.exit(0);
            case JOptionPane.YES_OPTION:
                UsuarioController.getInstancia().finalizarSessao();
                setVisible(false);
                getTelaAnterior().setVisible(true);
                return DO_NOTHING_ON_CLOSE;
            case JOptionPane.CANCEL_OPTION:
                return DO_NOTHING_ON_CLOSE;
            default:
                //TODO: adicionar excecao
                return EXIT_ON_CLOSE;
        }
        
    }
}
