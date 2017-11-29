
package br.ufla.dcc.ppoo.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public abstract class Tela extends JFrame {
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private Tela telaAnterior;
    
    public Tela(String titulo, int x, int y, Tela t) {
        super(titulo);
        setSize(x, y);
        setLocationRelativeTo(null);
        
        telaAnterior = t;
        
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
    
    public Tela getTelaAnterior() {
        return telaAnterior;
    }
    
    protected abstract void construirTela();
    protected abstract void adicionarAcoes();

    
    
}
