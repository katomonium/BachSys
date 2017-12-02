package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.componentes.Painel;
import br.ufla.dcc.ppoo.componentes.Tabela;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class TelaPrincipal extends Tela {
    
    private Painel painelDadosUsuario;
    private Painel painelAcoes;
    private Painel painelListaMusica;
    private JButton btnAdicionarMusica;
    private JButton btnEditarMusica;
    private JButton btnRemoverMusica;
    private JButton btnLogout;
    private JButton btnSair;
    private Tabela tblMusicas;
    private JScrollPane painelDeRolagem;
    private JCheckBox boxMusicasUsuario;
    
    public TelaPrincipal(Tela t) {
        super("BachSys", 800, 600, t);
        painelDeRolagem = null;
        construirTela();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        adicionarAcoes();
        
        
    }
    
    @Override
    protected void construirTela() {
        
        adicionaPainelAcoes();
        adicionarPainelDadosUsuario();
        adicionarPainelListaMusica();
        
    }
    
   
    
    private Object[][] formatarMusicas(String email){
        List<Musica> musicas = MusicaController.getInstancia().getMusicas(email);
        
        Object objetos[][] = new Object[musicas.size()][5];
        
        for(int i = 0; i < musicas.size(); i++){
            objetos[i][0] = musicas.get(i).getNome();
            objetos[i][1] = musicas.get(i).getAutor();
            objetos[i][2] = musicas.get(i).getAlbum();
            objetos[i][3] = musicas.get(i).getGenero();
            objetos[i][4] = musicas.get(i).getAno();
        }
        return objetos;
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
        
        boxMusicasUsuario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                List<Musica> musicas;
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    musicas = MusicaController.getInstancia().getMusicas(email);
                    
                } else {
                    musicas = MusicaController.getInstancia().getMusicas();
                }
                criaTabelaMusicas(musicas);
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

    
    
    private void adicionaPainelAcoes() {
        painelAcoes = new Painel(150, 350);
        painelAcoes.setBackground(Color.yellow);
        adicionarComponente(painelAcoes, GridBagConstraints.WEST, 
                GridBagConstraints.NONE, 1, 0, 1, 1);
        
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
     
    }

    
    
    private void adicionarPainelDadosUsuario() {
        painelDadosUsuario = new Painel(150, 200);
        painelDadosUsuario.setBackground(Color.white);
        adicionarComponente(painelDadosUsuario, GridBagConstraints.WEST, 
                GridBagConstraints.NONE, 0, 0, 1, 1);
        
        String nome = UsuarioController.getInstancia().getNomeUsuarioLogado();
        JLabel lbNome = new JLabel("Bem vindo, " + nome);
        painelDadosUsuario.adicionarComponente(lbNome, GridBagConstraints.CENTER, 
                                    GridBagConstraints.HORIZONTAL, 0, 0, 1, 1);
        
        String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
        
        JLabel lbEmail = new JLabel("Email: " + email);
        painelDadosUsuario.adicionarComponente(lbEmail, GridBagConstraints.CENTER, 
                                    GridBagConstraints.HORIZONTAL, 1, 0, 1, 1);
        
        Integer qtdMusicas = MusicaController.getInstancia().getQtdMusicas(email);
        JLabel lbQtdMusica = new JLabel("<html><body>Quantidade de"
                                        + " músicas cadastradas: " + qtdMusicas + "</body></html>");
        painelDadosUsuario.adicionarComponente(lbQtdMusica, GridBagConstraints.CENTER, 
                                    GridBagConstraints.HORIZONTAL, 2 , 0, 1, 4);
        
    }

    
    
    private void adicionarPainelListaMusica() {
        painelListaMusica = new Painel(600, 550);
        adicionarComponente(painelListaMusica, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 1, 1, 2);
        painelListaMusica.setBackground(Color.red);
        
        List<Musica> musicas = MusicaController.getInstancia().getMusicas();
        
        criaTabelaMusicas(musicas);
        boxMusicasUsuario = new JCheckBox("Ver apenas minhas músicas");
        painelListaMusica.adicionarComponente(boxMusicasUsuario,GridBagConstraints.WEST,
                                            GridBagConstraints.NONE, 0, 0, 1, 1, 0.1, 0.1);
    }
    
    
    public void criaTabelaMusicas(List<Musica> musicas) {
        
        if(painelDeRolagem != null) {
            painelDeRolagem.removeAll();
            painelListaMusica.remove(painelDeRolagem);
        }
        
        String[] colunas = {"Nome", "Autor", "Album", "Gênero", "Ano" };
        
        
        tblMusicas = new Tabela(musicas, colunas);
        
        
        painelDeRolagem = new JScrollPane();
        painelDeRolagem.setViewportView(tblMusicas);
        
        painelListaMusica.adicionarComponente(painelDeRolagem, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 1, 0, 1, 1, 1,1);
        
        painelListaMusica.revalidate();
        
    }
}
