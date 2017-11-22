package br.ufla.dcc.ppoo.view;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaPrincipal extends JFrame {
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    public TelaPrincipal() {
        super("BachSys");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        
        
        JButton jb = new JButton("arroz");
        adicionarComponente(jb, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 1, 1);
        JButton jb2 = new JButton("p");
        adicionarComponente(jb2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0, 0,0);
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
        this.add(comp);
    }
    
}
