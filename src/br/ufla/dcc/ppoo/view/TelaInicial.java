package br.ufla.dcc.ppoo.view;


<<<<<<< HEAD
import br.ufla.dcc.ppoo.controller.UsuarioController;
=======
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
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
    
    
<<<<<<< HEAD
    public TelaInicial(Tela t) {
        super("BachSys", 800, 600, t);
=======
    public TelaInicial() {
        super("BachSys", 800, 600);
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.construirTela();
     
        
    }
    
    @Override
    public void construirTela(){
<<<<<<< HEAD
        Tela t = this;
        btnLogin = new JButton("Login");
        adicionarComponente(btnLogin, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin(t).setVisible(true);
            }
        });
        
        
        btnRegistrar = new JButton("Não possui conta? Registre-se!");
        adicionarComponente(btnRegistrar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0, 1,1);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro(t).setVisible(true);
            }
        });
        

    }

=======
           
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
    
  
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
    
}
