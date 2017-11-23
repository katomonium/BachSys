package br.ufla.dcc.ppoo.view;


import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame {
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    private JLabel lbUsuario;
    private JLabel lbEmail;
    private JLabel lbSenha;
    private JLabel lbConfirmarSenha;
    
    private JTextField txtUsuario;
    private JTextField txtEmail;
    private JTextField txtSenha;
    private JTextField txtConfirmarSenha;
    
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private JPanel painelBotoes;
    
    public TelaCadastro() {
        super("Cadastro");
        
        setSize(600, 400);
             
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        setLayout(gbl);
        
        this.construirTela();
     
    }
    
    public void construirTela(){
        
        lbUsuario = new JLabel("Usuário:");
        adicionarComponente(lbUsuario, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 1 ,1);
        lbEmail = new JLabel("E-mail:");
        adicionarComponente(lbEmail, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 0, 1 ,1);
        lbSenha = new JLabel("Senha:");
        adicionarComponente(lbSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 2, 0, 1 ,1);
        lbConfirmarSenha = new JLabel("Confirmar Senha:");
        adicionarComponente(lbConfirmarSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 2, 2, 1 ,1);
        
        txtUsuario = new JTextField(10);
        adicionarComponente(txtUsuario, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 1, 3 ,1);
        txtEmail = new JTextField(10);
        adicionarComponente(txtEmail, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 1, 3 ,1);
        txtSenha = new JTextField(10);
        adicionarComponente(txtSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 2, 1, 1 ,1);
        txtConfirmarSenha = new JTextField(10);
        adicionarComponente(txtConfirmarSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 2, 3, 1 ,1);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        btnRegistrar = new JButton("Enviar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // IMPLEMENTAR CADASTRO DE USUARIO ###
            }
        });
        
        painelBotoes = new JPanel();
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnRegistrar);
        adicionarComponente(painelBotoes, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 3, 0, 4,1);
    }
    
    private void adicionarComponente(Component comp, int anchor, int fill,
            int linha, int coluna, int larg, int alt) {
        
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.gridx = coluna;
        gbc.gridy = linha;
        
        gbc.gridwidth = larg;
        gbc.gridheight = alt;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbl.setConstraints(comp, gbc);
        add(comp);
    }
    
}

