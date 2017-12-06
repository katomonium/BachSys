package br.ufla.dcc.ppoo.view;


import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.ConfirmacaoDeSenhaException;
import br.ufla.dcc.ppoo.exceptions.EmailInvalidoException;
import br.ufla.dcc.ppoo.exceptions.EmailJaCadastradoException;
import br.ufla.dcc.ppoo.exceptions.SenhaCurtaException;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastroUsuario extends Tela {
    
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
    
    public TelaCadastroUsuario(Tela t) {
        super("Cadastro", 500, 300, t);
        
        this.construirTela();
        
        this.adicionarAcoes();
     
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
                String confirmacaoSenha = txtConfirmarSenha.getText();
                
                try{                    
                    UsuarioController.getInstancia().cadastrar(usuario, email, senha, confirmacaoSenha);
                    setVisible(false);
                }
                catch(CampoVazioException cv){
                    JOptionPane.showMessageDialog(null, cv.getMessage(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch(ConfirmacaoDeSenhaException s){
                    JOptionPane.showMessageDialog(null, s.getMessage(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch(EmailJaCadastradoException ej){
                    JOptionPane.showMessageDialog(null, ej.getMessage(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch(SenhaCurtaException c){
                    JOptionPane.showMessageDialog(null, c.getMessage(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch(EmailInvalidoException ei){
                    JOptionPane.showMessageDialog(null, ei.getMessage(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
               
            }
        });
    }
}

