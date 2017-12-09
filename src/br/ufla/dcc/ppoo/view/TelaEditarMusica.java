
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaEditarMusica extends TelaLeDadosMusica {
    
    public TelaEditarMusica(Musica m, Tela t) {
        super("Editar Música", t);
        this.construirTela(m);
        super.adicionarAcoes();
    }

    protected void construirTela(Musica m) {

        
        setTxtNome(new JTextField(m.getNome(), 10));
        getTxtNome().setEnabled(false);
        getTxtNome().setEditable(false);
        setTxtAlbum(new JTextField(m.getAlbum(), 10));
        setTxtAno(new JTextField(Integer.toString(m.getAno()), 10));
        setTxtAutor(new JTextField(m.getAutor(), 10));
        setTxtGenero(new JTextField(m.getGenero(), 10));
        
        String[] t = m.getTags();
        String tags = "";
        
        for(String aux : t) {
            tags += " " + aux;
        }
        setTxtTags(new JTextField(tags, 10));
        
        super.construirTela();
        
    }

    @Override
    protected boolean executarAcaoSalvar(String nome, String autor, String album, Integer ano, String genero, String usuario, String[] tags) {
        try {
            MusicaController.getInstancia().modificarMusica(nome, autor, album, ano, genero, usuario, tags);
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CampoMinimoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
    
}
