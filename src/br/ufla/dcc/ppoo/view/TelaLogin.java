package br.ufla.dcc.ppoo.view;


import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Usuario;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JPasswordField;
=======
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
import javax.swing.JTextField;

public class TelaLogin extends Tela {

    private JLabel lbSenha;
    private JLabel lbEmail;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private JButton btnEnviar;
    private JPanel painelBotoes;
    
<<<<<<< HEAD
    public TelaLogin(Tela t) {
        super("Login", 500, 300, t);
=======
    public TelaLogin() {
        super("Login", 500, 300);
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
        

        this.construirTela();
     
    }
    
    @Override
    public void construirTela(){
        
        lbEmail = new JLabel("E-mail");
        adicionarComponente(lbEmail, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 1 ,1);
        lbSenha = new JLabel("Senha");
        adicionarComponente(lbSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 0, 1 ,1);
        
        txtEmail = new JTextField(20);
        adicionarComponente(txtEmail, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 1, 1 ,1);
        txtSenha = new JPasswordField(10);
        adicionarComponente(txtSenha, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 1, 1 ,1);
        
        
        btnCancelar = new JButton("Cancelar");
        
        btnEnviar = new JButton("Enviar");        
        
        painelBotoes = new JPanel();
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnEnviar);
        adicionarComponente(painelBotoes, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 2, 0, 2,1);
        
        btnRegistrar = new JButton("Não possui conta? Registre-se!");
        adicionarComponente(btnRegistrar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 3, 0, 2,1);
        
        adicionarAcoes();
        
    }

    @Override
    protected void adicionarAcoes() {
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
<<<<<<< HEAD
        
        Tela t = this;
        btnEnviar = new JButton("Enviar");
=======
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController.getInstancia().iniciarSessao(txtEmail.getText(), txtSenha.getText());
                if(UsuarioController.estaLogado()) {
                    setVisible(false);
                    new TelaPrincipal(t).setVisible(true);
                    getTelaAnterior().setVisible(false);
                    
                    
                }
            }
        });   
        
<<<<<<< HEAD
        painelBotoes = new JPanel();
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnEnviar);
        adicionarComponente(painelBotoes, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 2, 0, 2,1);
        
        
        btnRegistrar = new JButton("Não possui conta? Registre-se!");
=======
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro(t).setVisible(true);
            }
        });
<<<<<<< HEAD
        
        adicionarComponente(btnRegistrar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 3, 0, 2,1);
        
        
    }   
=======
    }
    
    
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
}

