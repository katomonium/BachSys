
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    protected boolean executarAcaoSalvar(String nome, String autor, String album, Integer ano, String genero, String usuario, String[] tags) {
        try {
            MusicaController.getInstancia().addMusica(nome, autor, album, ano, genero, usuario, tags);
            return true;
        } catch (MusicaJaCadastradaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
  
}
