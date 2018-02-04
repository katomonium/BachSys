package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.components.Painel;
import br.ufla.dcc.ppoo.components.Tabela;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
import br.ufla.dcc.ppoo.exceptions.SemRecomendacaoException;
import br.ufla.dcc.ppoo.model.Musica;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class TelaMusicas extends Tela {
    
    private Painel painelDadosUsuario;
    private Painel painelAcoes;
    private Painel painelListaMusica;
    private JButton btnAdicionarMusica;
    private JButton btnRemoverMusica;
    private JButton btnLogout;
    private JButton btnSair;
    private JButton btnRecomendacoes;
    private Tabela tblMusicas;
    private JScrollPane painelDeRolagem;
    private JCheckBox boxMusicasUsuario;
    private List<Musica> musicas;
    private JTextField txtBusca;
    private JButton btnBuscar;
    private JLabel lbQtdMusica;
    private JLabel lbEmail;
    private JLabel lbNome;
    private JLabel lbValorQtdMusica;
    private JLabel lbValorEmail;
    private JLabel lbValorNome;
    private JLabel imagem;

    
    public TelaMusicas(Tela t) {
        super("BachSys", 800, 600, t);
        atualizarListaMusicas();
        painelDeRolagem = null;
        construirTela();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        adicionarAcoes();
        pack();
        
    }
    
    private void atualizarListaMusicas() {
        try {
            musicas = MusicaController.getInstancia().getMusicas();
        } catch (ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void atualizarListaMusicas(String email) {
        try {
            musicas = MusicaController.getInstancia().getMusicas(email);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @Override
    protected void construirTela() {
        adicionarPainelAcoes();
        adicionarPainelDadosUsuario();
        adicionarPainelListaMusica();
        
    }
    
    
    private void setBoxMusicasTrue() {
        if(boxMusicasUsuario.isSelected()) {
            boxMusicasUsuario.setSelected(false);
        }

        boxMusicasUsuario.setSelected(true);
    }
    
    private void setBoxMusicasFalse() {
        if(!boxMusicasUsuario.isSelected()) {
            boxMusicasUsuario.setSelected(true);
        }

        boxMusicasUsuario.setSelected(false);
    }
    
    private void removeMusicasSelecionadas() {
        boolean achou = false;
        int colCheckBox = Tabela.getColunaCheckBox();
        for(int row = 0; row < tblMusicas.getRowCount(); row++) {
            Boolean musicaSelecionada = (Boolean) (tblMusicas.getModel().getValueAt(row, colCheckBox));
            if(musicaSelecionada) {
                achou = true;
                String nome = tblMusicas.getModel().getValueAt(row, 0).toString();
                try {
                    String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    MusicaController.getInstancia().removerMusica(nome, email);
                    atualizarListaMusicas(email);
                    tblMusicas.removeRowSelectionInterval(row, row);
                } catch (IOException | ClassNotFoundException | MusicaNaoEncontradaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 
                                                    JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        setBoxMusicasTrue();
        if(!achou){
            JOptionPane.showMessageDialog(null, "Nenhuma música foi selecionada.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @Override
    protected void adicionarAcoes() {
        Tela t = this;
        
        btnAdicionarMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaCadastroMusica tcm = new TelaCadastroMusica(t);
                tcm.setVisible(true);
                tcm.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        setBoxMusicasTrue();
                        try {
                            String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                            lbValorQtdMusica.setText(MusicaController.getInstancia().getQtdMusicas(email) + "");
                        } catch (IOException | ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                });
            }
        });
        
       
        btnRemoverMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(boxMusicasUsuario.isSelected()) {
                    String texto = "Deseja realmente remover as musicas selecionadas?\nOs comentários das músicas também serão removidos.";
                    int confirmacao = JOptionPane.showConfirmDialog(null, texto,
                                                "Remover musicas", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(confirmacao == JOptionPane.NO_OPTION) {
                        return;
                    }
                    if(confirmacao == JOptionPane.YES_OPTION) {
                        removeMusicasSelecionadas();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione a opção \"Ver apenas minhas músicas\" e escolha as músicas a serem removidas.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(UsuarioController.getInstancia().estaLogado()) {
                        Integer opcao = JOptionPane.showConfirmDialog(null, 
                                            "Deseja realmente realizar logout?", "Realizar logout?",
                                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                        if(opcao == JOptionPane.YES_OPTION) {
                            getTelaAnterior().setVisible(true);
                            UsuarioController.getInstancia().finalizarSessao();
                            setVisible(false);
                        }
                    }
                } catch (ClassNotFoundException | IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 
                                                    JOptionPane.ERROR_MESSAGE);
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
                
                Boolean mostrarCheckBox;
                try {
                    String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    if (ie.getStateChange() == ItemEvent.SELECTED) {
                        atualizarListaMusicas(email);
                        mostrarCheckBox = true;
                    } else {
                        atualizarListaMusicas();
                        mostrarCheckBox = false;
                    }
                    if(!textoBotaoBuscaEhBuscar()) {
                        btnBuscar.setText("Buscar");
                    }
                    criaTabelaMusicas(musicas, mostrarCheckBox);
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 
                                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnRecomendacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    musicas = MusicaController.getInstancia().getRecomendacoes(email);
                    criaTabelaMusicas(musicas, false);
                } catch (IOException | ClassNotFoundException | SemRecomendacaoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 
                                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    
    private Integer confirmarSaida() {
        Integer opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmar saída",
                                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        switch (opcao) {
            case JOptionPane.YES_OPTION:
                try {
                    UsuarioController.getInstancia().finalizarSessao();
                    System.exit(0);
                } catch(ClassNotFoundException | IOException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
                                                    JOptionPane.ERROR_MESSAGE);
                }
            case JOptionPane.NO_OPTION:
                return DO_NOTHING_ON_CLOSE;
            default:
                return EXIT_ON_CLOSE;
        }
        
    }

    
    
    private void adicionarPainelAcoes() {
        painelAcoes = new Painel(200, 350);
//        painelAcoes.setBackground(Color.yellow);
        adicionarComponente(painelAcoes, GridBagConstraints.WEST, 
                GridBagConstraints.NONE, 1, 0, 1, 1);
        
        
        
        btnAdicionarMusica = new JButton("Adicionar");
        btnAdicionarMusica.setToolTipText("Adicionar uma musica ao catalogo");
        painelAcoes.adicionarComponente(btnAdicionarMusica, GridBagConstraints.CENTER,
                                        GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, 0);

        
        btnRemoverMusica = new JButton("Remover");
        btnRemoverMusica.setToolTipText("Remover mussicas do catalogo");
        painelAcoes.adicionarComponente(btnRemoverMusica, GridBagConstraints.CENTER,
                                        GridBagConstraints.BOTH, 1, 0, 1, 1, 0.5, 0);

        btnRecomendacoes = new JButton("Recomendaçoes");
        btnRecomendacoes.setToolTipText("Musicas recomendadas");
        painelAcoes.adicionarComponente(btnRecomendacoes, GridBagConstraints.CENTER,
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
        try {
            painelDadosUsuario = new Painel(200, 250);
        
//            painelDadosUsuario.setBackground(Color.white);
            adicionarComponente(painelDadosUsuario, GridBagConstraints.WEST, 
                    GridBagConstraints.NONE, 0, 0, 1, 1);
            
            
            String nome = UsuarioController.getInstancia().getNomeUsuarioLogado();
            lbNome = new JLabel("Bem vindo,");
            lbNome.setFont(new Font("Dialog", Font.BOLD, 15));
            painelDadosUsuario.adicionarComponente(lbNome, GridBagConstraints.CENTER, 
                                        GridBagConstraints.NONE, 0, 0, 1, 1);
            
            lbValorNome = new JLabel(nome);
            lbValorNome.setFont(new Font("Dialog", Font.BOLD, 15));
            painelDadosUsuario.adicionarComponente(lbValorNome, GridBagConstraints.CENTER, 
                                        GridBagConstraints.NONE, 1, 0, 1, 1);
            
            imagem = new JLabel(new ImageIcon("./images/music-player.png"));
            painelDadosUsuario.adicionarComponente(imagem, GridBagConstraints.CENTER, 
                                        GridBagConstraints.HORIZONTAL, 2, 0, 1, 1);
            
            String email = UsuarioController.getInstancia().getEmailUsuarioLogado();
            lbEmail = new JLabel("Email:");
            painelDadosUsuario.adicionarComponente(lbEmail, GridBagConstraints.CENTER, 
                                        GridBagConstraints.HORIZONTAL, 3, 0, 1, 1);
            lbValorEmail = new JLabel(email);
            painelDadosUsuario.adicionarComponente(lbValorEmail, GridBagConstraints.CENTER, 
                                        GridBagConstraints.HORIZONTAL, 4, 0, 1, 1);

            Integer qtdMusicas;
            qtdMusicas = MusicaController.getInstancia().getQtdMusicas(email);
            lbQtdMusica = new JLabel("Quantidade de músicas: ");
            painelDadosUsuario.adicionarComponente(lbQtdMusica, GridBagConstraints.CENTER, 
                                    GridBagConstraints.HORIZONTAL, 5 , 0, 1, 1);
            lbValorQtdMusica = new JLabel(qtdMusicas.toString());
            painelDadosUsuario.adicionarComponente(lbValorQtdMusica, GridBagConstraints.CENTER, 
                                    GridBagConstraints.HORIZONTAL, 6 , 0, 1, 1);
            
        } catch (ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    
    
    private void adicionarPainelListaMusica() {
        painelListaMusica = new Painel(650, 550);
        adicionarComponente(painelListaMusica, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 1, 1, 2);
//        painelListaMusica.setBackground(Color.red);
        
        
       
        criaTabelaMusicas(musicas, false);

        boxMusicasUsuario = new JCheckBox("Ver apenas minhas músicas");
        painelListaMusica.adicionarComponente(boxMusicasUsuario, GridBagConstraints.WEST,
                                            GridBagConstraints.NONE, 0, 2, 1, 1, 0.1, 0.1);
        adicionarBarraBusca();
    }
    
    
    private void criaTabelaMusicas(List<Musica> musicas, Boolean mostrarCheckBox) {
        
        if(painelDeRolagem != null) {
            painelDeRolagem.removeAll();
            painelListaMusica.remove(painelDeRolagem);
        }
        
        String[] colunas = {"Nome", "Autor", "Album", "Gênero", "Ano", "Pontos"};
        
        
        tblMusicas = new Tabela(musicas, colunas, mostrarCheckBox);
        
        
        painelDeRolagem = new JScrollPane();
        painelDeRolagem.setViewportView(tblMusicas);
        
        painelListaMusica.adicionarComponente(painelDeRolagem, GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH, 1, 0, 3, 1, 1, 1);
        
        painelListaMusica.revalidate();
        
        adicionarAcoesTabela();
        
        
    }
    
    private void adicionarAcoesTabela() {
        Tela t = this;
        
        tblMusicas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getClickCount() == 2){
                    int column = tblMusicas.getSelectedColumn();
                    int row = tblMusicas.getSelectedRow();
                    if(column == tblMusicas.getColunaCheckBox()) {
                        return;
                    }
                    TelaVisualizarMusica tdm = new TelaVisualizarMusica(musicas.get(row), t);
                    
                    tdm.setVisible(true);
                    tdm.addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentHidden(ComponentEvent e) {
                            if(tdm.musicaAlterada()) {
                                setBoxMusicasTrue();
                            }
                            if(tdm.musicaAvaliada()) {
                                setBoxMusicasFalse();
                            }
                            if(tdm.musicaAdicionada()) {
                                setBoxMusicasTrue();
                            }
                        }
                    });

                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                return;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                return;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                return;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                return;
            }
            
        });
    }

    private void adicionarBarraBusca() {
        txtBusca = new JTextField(20);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String palavraChave = txtBusca.getText();
                try {
                    if(textoBotaoBuscaEhBuscar()) {
                        musicas = MusicaController.getInstancia().buscarMusicas(palavraChave);
                        criaTabelaMusicas(musicas, false);
                        btnBuscar.setText("Ver todas");
                    } else {
                        setBoxMusicasFalse();
                        btnBuscar.setText("Buscar");
                    }
                } catch (IOException | ClassNotFoundException | CampoVazioException |
                        MusicaNaoEncontradaException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
            }
        });
        
        
        
        painelListaMusica.adicionarComponente(txtBusca, GridBagConstraints.CENTER,
                                        GridBagConstraints.NONE, 0, 0, 1, 1);
    
        painelListaMusica.adicionarComponente(btnBuscar, GridBagConstraints.CENTER,
                                        GridBagConstraints.NONE, 0, 1, 1, 1);
    }
    
    private Boolean textoBotaoBuscaEhBuscar() {
        if(btnBuscar.getText().equals("Buscar")) {
            return true;
        }
        return false;
    }
    
}
