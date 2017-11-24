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

public class TelaPrincipal extends JFrame {
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    JButton btnLogin;
    JButton btnRegistrar;
    JTextArea txt;
    
    
    public TelaPrincipal() {
        super("BachSys");
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        setLayout(gbl);
        
        this.construirTela();
     
        
        }
    
    public void construirTela(){
           
        btnLogin = new JButton("Login");
        adicionarComponente(btnLogin, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin().setVisible(true);
            }
        });
    
        btnRegistrar = new JButton("Não possui conta? Registre-se!");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
            }
        });
        adicionarComponente(btnRegistrar, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0, 1,1);
    
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
