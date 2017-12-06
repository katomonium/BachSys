
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroMusica extends TelaLeDadosMusica {
    
    

    public TelaCadastroMusica(Tela t) {
        super("Cadastrar música", t);
        construirTela();
        super.adicionarAcoes();
    }

    @Override
    protected void construirTela() {

        
        setTxtNome(new JTextField(10));
        setTxtAlbum(new JTextField(10));
        setTxtAno(new JTextField(10));
        setTxtAutor(new JTextField(10));
        setTxtGenero(new JTextField(10));
        setTxtTags(new JTextField(10));
        
        super.construirTela();
        
    }
    

    
    
}
