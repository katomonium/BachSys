package br.ufla.dcc.ppoo.view;


import br.ufla.dcc.ppoo.controller.UsuarioController;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastro extends Tela {
    
    private JLabel lbUsuario;
    private JLabel lbEmail;
    private JLabel lbSenha;
    private JLabel lbConfirmarSenha;
    
    private JTextField txtUsuario;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private JPanel painelBotoes;
    
    public TelaCadastro() {
        super("Cadastro", 600, 400);
        
        this.construirTela();
     
    }
    
    @Override
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
        txtSenha = new JPasswordField(10);
        adicionarComponente(txtSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 2, 1, 1 ,1);
        txtConfirmarSenha = new JPasswordField(10);
        adicionarComponente(txtConfirmarSenha, GridBagConstraints.CENTER, GridBagConstraints.NONE, 2, 3, 1 ,1);
        
        btnCancelar = new JButton("Cancelar");
        
        
        btnRegistrar = new JButton("Enviar");
        
        
        painelBotoes = new JPanel();
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnRegistrar);
        adicionarComponente(painelBotoes, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 3, 0, 4,1);
        
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
        
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String email = txtEmail.getText();
                String senha = txtSenha.getText();
                String confirmarSenha = txtConfirmarSenha.getText();
                
                if((senha.length() >= 4) && (senha.equals(confirmarSenha))
                    && (usuario.length() >= 1) && (verificarEmail(email))
                    ){
                    UsuarioController.getInstancia().cadastrar(usuario, email, senha);
                    setVisible(false);
                }
                else{
                    if(usuario.length()< 1) {
                        JOptionPane.showMessageDialog(null, "Digite seu nome de usuário!", 
                                "Usuário inválido", JOptionPane.ERROR_MESSAGE);
                    } else if(!verificarEmail(email)) {
                        JOptionPane.showMessageDialog(null, "Digite um email válido!", 
                                "Email inválido", JOptionPane.ERROR_MESSAGE);
                    } else if(senha.length() < 4) {
                        JOptionPane.showMessageDialog(null, "A senha deve conter no mínimo 4 catacteres!",
                                "Senha inválida", JOptionPane.ERROR_MESSAGE);
                    } else if(!senha.equals(confirmarSenha)) {
                        JOptionPane.showMessageDialog(null, "A senha está diferente da confirmação de senha!", 
                                "Confirmação de senha errada", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
    
    private Boolean verificarEmail(String email) {
        if(email.length() < 5) {
            return false;
        }
        Boolean achou = false;
        int posAchou = -1;
        for(int i = 0; (i < email.length()) && (!achou); i++) {
            if(email.charAt(i) == '@') {
                achou = true;
                posAchou = i;
            }
        }
        if(!achou) {
            return false;
        }
        
        achou = false;
        for(int i = posAchou; (i < email.length() - 1) && (!achou); i++) {
            if(email.charAt(i) == '.') {
                achou = true;
            }
        }
        
        if(!achou) {
            return false;
        }
        return true;   
    }
}

