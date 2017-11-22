package br.ufla.dcc.ppoo.view;


import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TelaPrincipal extends JFrame {
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    JButton jb;
    JButton jb2;
    JButton jb3;
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
           
        jb = new JButton("arroz");
        adicionarComponente(jb, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 1, 1);
        jb2 = new JButton("p");
        adicionarComponente(jb2, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 0, 1 ,1);
        jb3 = new JButton("KKK");
        adicionarComponente(jb3, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 1, 1 ,1);
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
