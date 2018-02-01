
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import java.io.IOException;
import javax.swing.JOptionPane;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
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
            MusicaController.getInstancia().adicionarMusica(nome, nome, autor, album, ano, genero, usuario, tags);
            return true;
        } catch (MusicaJaCadastradaException | IOException | ClassNotFoundException 
                | CampoVazioException | CampoMinimoException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
  
}
