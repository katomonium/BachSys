
package br.ufla.dcc.ppoo.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public abstract class Tela extends JFrame {
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
<<<<<<< HEAD
    private Tela telaAnterior;
    
    public Tela(String titulo, int x, int y, Tela t) {
=======
    
    
    public Tela(String titulo, int x, int y) {
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
        super(titulo);
        setSize(x, y);
        setLocationRelativeTo(null);
        
<<<<<<< HEAD
        telaAnterior = t;
        
=======
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
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
<<<<<<< HEAD

    public Tela getTelaAnterior() {
        return telaAnterior;
    }
=======
    protected abstract void adicionarAcoes();
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
    
}
