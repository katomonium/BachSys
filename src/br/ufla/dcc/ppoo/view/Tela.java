
package br.ufla.dcc.ppoo.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public abstract class Tela extends JFrame {
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    
    public Tela(String titulo, int x, int y) {
        super(titulo);
        setSize(x, y);
        setLocationRelativeTo(null);
        
        gbc = new GridBagConstraints();
        gbl = new GridBagLayout();
        
        setLayout(gbl);

    }
   
      
    protected void adicionarComponente(Component comp, int anchor, int fill,
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
    
    
    protected abstract void construirTela();
    protected abstract void adicionarAcoes();
    
}
