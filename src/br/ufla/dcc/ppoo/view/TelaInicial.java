package br.ufla.dcc.ppoo.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TelaInicial extends Tela {
    JLabel boasVindas;
    JLabel imagem;
    JButton btnLogin;
    JButton btnRegistrar;
    JTextArea txt;
    
    
    public TelaInicial(Tela t) {
        super("BachSys", 250, 300, t);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.construirTela();
        
        this.adicionarAcoes();

    }
    
    @Override
    public void construirTela(){
        boasVindas =  new JLabel("Bem-vindo ao BachSys!");
        boasVindas.setFont(new Font("Dialog", Font.BOLD, 20));
        adicionarComponente(boasVindas, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 1, 1);

        imagem = new JLabel(new ImageIcon("./images/music.png"));
        adicionarComponente(imagem, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0, 1, 1);

        btnLogin = new JButton("Login");
        adicionarComponente(btnLogin, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 2, 0, 1, 1);
        
        btnRegistrar = new JButton("Não possui conta? Registre-se!");
        adicionarComponente(btnRegistrar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 3, 0, 1,1);
        
    }

    @Override
    protected void adicionarAcoes() {
        
        Tela t = this;
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin(t).setVisible(true);
            }
        });
        
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroUsuario(t).setVisible(true);
            }
        });
    }
}
