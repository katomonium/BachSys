
package br.ufla.dcc.ppoo.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class PainelDeRolagem extends JScrollPane{
    Painel painel;
    
    public PainelDeRolagem(Painel p, int vertical, int horizontal){
        super(p); 
        setPreferredSize(new Dimension(300, 300));
        painel = p;
        
    }
    
    public void adicionarComponente(Component comp, int anchor, int fill,
            int linha, int coluna, int larg, int alt) {
        painel.adicionarComponente(comp, anchor, fill, linha, coluna, larg, alt);
    }

}
