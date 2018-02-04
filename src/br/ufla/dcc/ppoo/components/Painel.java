package br.ufla.dcc.ppoo.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

public class Painel extends JPanel {
    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    public Painel(int x, int y) {
        super();
        
        setPreferredSize(new Dimension(x, y));
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        setLayout(gbl);
    }
    
    public void adicionarComponente(Component comp, int anchor, int fill,
            int linha, int coluna, int larg, int alt) {
        
        
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.gridx = coluna;
        gbc.gridy = linha;

        gbc.gridwidth = larg;
        gbc.gridheight = alt;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbl.setConstraints(comp, gbc);
        add(comp);
    }
    
    public void adicionarComponente(Component comp, int anchor, int fill,
            int linha, int coluna, int larg, int alt, double weightx, double weighty) {
        
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        
        adicionarComponente(comp, anchor, fill, linha, coluna, larg, alt);
        
    }
    
}
