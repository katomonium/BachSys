package br.ufla.dcc.ppoo.view;


import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TelaInicial extends Tela {
    
    JButton btnLogin;
    JButton btnRegistrar;
    JTextArea txt;
    
    
    public TelaInicial() {
        super("BachSys", 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.construirTela();
     
        
    }
    
    @Override
    public void construirTela(){
           
        btnLogin = new JButton("Login");
        adicionarComponente(btnLogin, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1);
    
        btnRegistrar = new JButton("Não possui conta? Registre-se!");
        adicionarComponente(btnRegistrar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0, 1,1);
        
        adicionarAcoes();
    }

    @Override
    protected void adicionarAcoes() {
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin().setVisible(true);
            }
        });
        
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
            }
        });
    }
    
  
    
}
